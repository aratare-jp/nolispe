/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package filesystem.provider;

import filesystem.util.FilesystemAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FilesystemItemProviderAdapterFactory extends FilesystemAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
   * This keeps track of the root adapter factory that delegates to this adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
   * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
   * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
   * This constructs an instance.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public FilesystemItemProviderAdapterFactory() {
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(IItemPropertySource.class);
  }

	/**
   * This keeps track of the one adapter used for all {@link filesystem.Filesystem} instances.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected FilesystemItemProvider filesystemItemProvider;

	/**
   * This creates an adapter for a {@link filesystem.Filesystem}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Adapter createFilesystemAdapter() {
    if (filesystemItemProvider == null)
    {
      filesystemItemProvider = new FilesystemItemProvider(this);
    }

    return filesystemItemProvider;
  }

	/**
   * This keeps track of the one adapter used for all {@link filesystem.Drive} instances.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected DriveItemProvider driveItemProvider;

	/**
   * This creates an adapter for a {@link filesystem.Drive}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Adapter createDriveAdapter() {
    if (driveItemProvider == null)
    {
      driveItemProvider = new DriveItemProvider(this);
    }

    return driveItemProvider;
  }

	/**
   * This keeps track of the one adapter used for all {@link filesystem.Folder} instances.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected FolderItemProvider folderItemProvider;

	/**
   * This creates an adapter for a {@link filesystem.Folder}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Adapter createFolderAdapter() {
    if (folderItemProvider == null)
    {
      folderItemProvider = new FolderItemProvider(this);
    }

    return folderItemProvider;
  }

	/**
   * This keeps track of the one adapter used for all {@link filesystem.Shortcut} instances.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ShortcutItemProvider shortcutItemProvider;

	/**
   * This creates an adapter for a {@link filesystem.Shortcut}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Adapter createShortcutAdapter() {
    if (shortcutItemProvider == null)
    {
      shortcutItemProvider = new ShortcutItemProvider(this);
    }

    return shortcutItemProvider;
  }

	/**
   * This keeps track of the one adapter used for all {@link filesystem.Sync} instances.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected SyncItemProvider syncItemProvider;

	/**
   * This creates an adapter for a {@link filesystem.Sync}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Adapter createSyncAdapter() {
    if (syncItemProvider == null)
    {
      syncItemProvider = new SyncItemProvider(this);
    }

    return syncItemProvider;
  }

	/**
   * This keeps track of the one adapter used for all {@link filesystem.File} instances.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected FileItemProvider fileItemProvider;

	/**
   * This creates an adapter for a {@link filesystem.File}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Adapter createFileAdapter() {
    if (fileItemProvider == null)
    {
      fileItemProvider = new FileItemProvider(this);
    }

    return fileItemProvider;
  }

	/**
   * This returns the root adapter factory that contains this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ComposeableAdapterFactory getRootAdapterFactory() {
    return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
  }

	/**
   * This sets the composed adapter factory that contains this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
    this.parentAdapterFactory = parentAdapterFactory;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean isFactoryForType(Object type) {
    return supportedTypes.contains(type) || super.isFactoryForType(type);
  }

	/**
   * This implementation substitutes the factory itself as the key for the adapter.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
    return super.adapt(notifier, this);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object adapt(Object object, Object type) {
    if (isFactoryForType(type))
    {
      Object adapter = super.adapt(object, type);
      if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter)))
      {
        return adapter;
      }
    }

    return null;
  }

	/**
   * This adds a listener.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void addListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.addListener(notifyChangedListener);
  }

	/**
   * This removes a listener.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.removeListener(notifyChangedListener);
  }

	/**
   * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void fireNotifyChanged(Notification notification) {
    changeNotifier.fireNotifyChanged(notification);

    if (parentAdapterFactory != null)
    {
      parentAdapterFactory.fireNotifyChanged(notification);
    }
  }

	/**
   * This disposes all of the item providers created by this factory. 
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void dispose() {
    if (filesystemItemProvider != null) filesystemItemProvider.dispose();
    if (driveItemProvider != null) driveItemProvider.dispose();
    if (folderItemProvider != null) folderItemProvider.dispose();
    if (shortcutItemProvider != null) shortcutItemProvider.dispose();
    if (syncItemProvider != null) syncItemProvider.dispose();
    if (fileItemProvider != null) fileItemProvider.dispose();
  }

}
