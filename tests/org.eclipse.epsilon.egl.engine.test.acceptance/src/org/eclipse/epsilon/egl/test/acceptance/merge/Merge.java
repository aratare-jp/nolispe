/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.test.acceptance.merge;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.status.ProtectedRegionWarning;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.eclipse.epsilon.egl.test.models.Model;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

// Force mergeAbsent to run before mergeAbsentNested
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class Merge {
	private static File StoreProgram;
	private static File GenerateProgram;
	private static File GenerateAbsentProgram;
	private static File GenerateAbsentNestedProgram;
	private static File OverwriteProgram;
	private static File DuplicatePRProgram;
	
	private static File PetOverwrite;
	private static File PetGenerate;
	private static File PetGenerateAbsent;
	private static File PetStore;
	
	private static File ExistingGenerate;
	
	private static File   ExpectedGenerate;
	private static File   ExpectedOverwrite;
	private static File   ExpectedGenerateAbsent;
	private static String ExpectedStore = "This file has not been generated by EGL.";
	
	@BeforeClass
	public static void setUpOnce() throws IOException {
		StoreProgram                = FileUtil.getFileStandalone("Store.egl", Merge.class);
		GenerateProgram             = FileUtil.getFileStandalone("Generate.egl", Merge.class);
		GenerateAbsentProgram       = FileUtil.getFileStandalone("GenerateAbsent.egl", Merge.class);
		GenerateAbsentNestedProgram = FileUtil.getFileStandalone("GenerateAbsentNested.egl", Merge.class);
		OverwriteProgram            = FileUtil.getFileStandalone("Overwrite.egl", Merge.class);
		DuplicatePRProgram          = FileUtil.getFileStandalone("DuplicateProtectedRegion.egl", Merge.class);
		
		PetOverwrite           = FileUtil.getFileStandalone("Pet_overwrite.txt", Merge.class);
		PetGenerate            = FileUtil.getFileStandalone("Pet_generate.txt", Merge.class);
		PetGenerateAbsent      = FileUtil.getFileStandalone("Pet_generateAbsent.txt", Merge.class);
		PetStore               = FileUtil.getFileStandalone("Pet_store.txt", Merge.class);
		
		ExistingGenerate       = FileUtil.getFileStandalone("Existing_generate.txt", Merge.class);
		
		ExpectedGenerate       = FileUtil.getFileStandalone("Expected_generate.txt", Merge.class);
		ExpectedGenerateAbsent = FileUtil.getFileStandalone("Expected_generateAbsent.txt", Merge.class);
		ExpectedOverwrite      = FileUtil.getFileStandalone("Expected_overwrite.txt", Merge.class);
		
		// Load imported files
		FileUtil.getFileStandalone("OOClass2JavaClass.egl", Merge.class);
		FileUtil.getFileStandalone("OOClass2JavaClassUnprotected.egl", Merge.class);
		
		org.eclipse.epsilon.egl.util.FileUtil.write(PetStore,          ExpectedStore);
		org.eclipse.epsilon.egl.util.FileUtil.write(PetOverwrite,      ExpectedStore);
		org.eclipse.epsilon.egl.util.FileUtil.write(PetGenerate,       org.eclipse.epsilon.egl.util.FileUtil.read(ExistingGenerate));
		org.eclipse.epsilon.egl.util.FileUtil.write(PetGenerateAbsent, org.eclipse.epsilon.egl.util.FileUtil.read(ExistingGenerate));
	}
	
	@Test
	public void mergeStore() throws Exception {
		AcceptanceTestUtil.run(StoreProgram, Model.OOInstance);
		assertEquals(ExpectedStore, PetStore);
	}
	
	@Test
	public void mergeGenerate() throws Exception {
		AcceptanceTestUtil.run(GenerateProgram, Model.OOInstance);
		assertEquals(ExpectedGenerate, PetGenerate);
	}
	
	@Test
	public void mergeOverwrite() throws Exception {
		AcceptanceTestUtil.run(OverwriteProgram, Model.OOInstance);
		assertEquals(ExpectedOverwrite, PetOverwrite);
	}
	
	@Test (expected=EglRuntimeException.class)
	public void mergeDuplicatePR() throws Exception {
		AcceptanceTestUtil.run(DuplicatePRProgram, Model.OOInstance);
	}
	
	@Test
	public void mergeAbsent() throws Exception {
		AcceptanceTestUtil.run(GenerateAbsentProgram, Model.OOInstance);
		assertFoundProtectedRegionWarnings();
	}
	
	@Test
	public void mergeAbsentNested() throws Exception {
		org.eclipse.epsilon.egl.util.FileUtil.write(PetGenerateAbsent, org.eclipse.epsilon.egl.util.FileUtil.read(ExistingGenerate));
		AcceptanceTestUtil.run(GenerateAbsentNestedProgram, Model.OOInstance);
		assertFoundProtectedRegionWarnings();
	}
	
	private static void assertFoundProtectedRegionWarnings() throws IOException {
		assertEquals(ExpectedGenerateAbsent, PetGenerateAbsent);
		
		boolean javadocWarningFound = false;
		boolean talkWarningFound    = false;
		boolean sleepWarningFound   = false;
		
		for (StatusMessage message : AcceptanceTestUtil.getStatusMessages()) {
			if (message instanceof ProtectedRegionWarning) {
				String id = ((ProtectedRegionWarning)message).getId();
				
				if (id.equals("javadoc")) javadocWarningFound = true;
				else if (id.equals("talk"))    talkWarningFound = true;
				else if (id.equals("sleep"))   sleepWarningFound = true;
			}
		}
		
		assertTrue("Expected warning for protected region 'javadoc'", javadocWarningFound);
		assertTrue("Expected warning for protected region 'talk'",    talkWarningFound);
		assertTrue("Expected warning for protected region 'sleep'",   sleepWarningFound);
	}
	
	private static void assertEquals(File expected, File actual) throws IOException {
		assertEquals(org.eclipse.epsilon.egl.util.FileUtil.read(expected), actual);
	}
	
	private static void assertEquals(String expected, File actual) throws IOException {
		org.junit.Assert.assertEquals(expected, org.eclipse.epsilon.egl.util.FileUtil.read(actual));
	}
}