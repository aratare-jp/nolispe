/*
 * 
 */
package flowchart.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import flowchart.Flowchart;
import flowchart.FlowchartPackage;
import flowchart.diagram.edit.parts.ActionEditPart;
import flowchart.diagram.edit.parts.ActionNameEditPart;
import flowchart.diagram.edit.parts.DecisionEditPart;
import flowchart.diagram.edit.parts.DecisionNameEditPart;
import flowchart.diagram.edit.parts.FlowchartEditPart;
import flowchart.diagram.edit.parts.SubflowEditPart;
import flowchart.diagram.edit.parts.SubflowNameEditPart;
import flowchart.diagram.edit.parts.TransitionEditPart;
import flowchart.diagram.edit.parts.TransitionNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class FlowchartVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.epsilon.eugenia.examples.flowchart.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (FlowchartEditPart.MODEL_ID.equals(view.getType())) {
				return FlowchartEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return flowchart.diagram.part.FlowchartVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				FlowchartDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (FlowchartPackage.eINSTANCE.getFlowchart().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Flowchart) domainElement)) {
			return FlowchartEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = flowchart.diagram.part.FlowchartVisualIDRegistry
				.getModelID(containerView);
		if (!FlowchartEditPart.MODEL_ID.equals(containerModelID)
				&& !"flowchart".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (FlowchartEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = flowchart.diagram.part.FlowchartVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FlowchartEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case FlowchartEditPart.VISUAL_ID:
			if (FlowchartPackage.eINSTANCE.getSubflow().isSuperTypeOf(
					domainElement.eClass())) {
				return SubflowEditPart.VISUAL_ID;
			}
			if (FlowchartPackage.eINSTANCE.getAction().isSuperTypeOf(
					domainElement.eClass())) {
				return ActionEditPart.VISUAL_ID;
			}
			if (FlowchartPackage.eINSTANCE.getDecision().isSuperTypeOf(
					domainElement.eClass())) {
				return DecisionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = flowchart.diagram.part.FlowchartVisualIDRegistry
				.getModelID(containerView);
		if (!FlowchartEditPart.MODEL_ID.equals(containerModelID)
				&& !"flowchart".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (FlowchartEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = flowchart.diagram.part.FlowchartVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FlowchartEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case FlowchartEditPart.VISUAL_ID:
			if (SubflowEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DecisionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubflowEditPart.VISUAL_ID:
			if (SubflowNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionEditPart.VISUAL_ID:
			if (ActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DecisionEditPart.VISUAL_ID:
			if (DecisionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPart.VISUAL_ID:
			if (TransitionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (FlowchartPackage.eINSTANCE.getTransition().isSuperTypeOf(
				domainElement.eClass())) {
			return TransitionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Flowchart element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case FlowchartEditPart.VISUAL_ID:
			return false;
		case SubflowEditPart.VISUAL_ID:
		case DecisionEditPart.VISUAL_ID:
		case ActionEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return flowchart.diagram.part.FlowchartVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return flowchart.diagram.part.FlowchartVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return flowchart.diagram.part.FlowchartVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return flowchart.diagram.part.FlowchartVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return flowchart.diagram.part.FlowchartVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return flowchart.diagram.part.FlowchartVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
