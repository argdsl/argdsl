/**
 */
package Ardsl.provider;

import Ardsl.util.ArdslAdapterFactory;

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
public class ArdslItemProviderAdapterFactory extends ArdslAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public ArdslItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Ontological} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OntologicalItemProvider ontologicalItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Ontological}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOntologicalAdapter() {
		if (ontologicalItemProvider == null) {
			ontologicalItemProvider = new OntologicalItemProvider(this);
		}

		return ontologicalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Graphic} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicItemProvider graphicItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Graphic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGraphicAdapter() {
		if (graphicItemProvider == null) {
			graphicItemProvider = new GraphicItemProvider(this);
		}

		return graphicItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Physic} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicItemProvider physicItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Physic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPhysicAdapter() {
		if (physicItemProvider == null) {
			physicItemProvider = new PhysicItemProvider(this);
		}

		return physicItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Game} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GameItemProvider gameItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Game}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGameAdapter() {
		if (gameItemProvider == null) {
			gameItemProvider = new GameItemProvider(this);
		}

		return gameItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.GamePad} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GamePadItemProvider gamePadItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.GamePad}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGamePadAdapter() {
		if (gamePadItemProvider == null) {
			gamePadItemProvider = new GamePadItemProvider(this);
		}

		return gamePadItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Class} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassItemProvider classItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createClassAdapter() {
		if (classItemProvider == null) {
			classItemProvider = new ClassItemProvider(this);
		}

		return classItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Attribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeItemProvider attributeItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Attribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeAdapter() {
		if (attributeItemProvider == null) {
			attributeItemProvider = new AttributeItemProvider(this);
		}

		return attributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Reference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceItemProvider referenceItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Reference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReferenceAdapter() {
		if (referenceItemProvider == null) {
			referenceItemProvider = new ReferenceItemProvider(this);
		}

		return referenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.GraphicClass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicClassItemProvider graphicClassItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.GraphicClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGraphicClassAdapter() {
		if (graphicClassItemProvider == null) {
			graphicClassItemProvider = new GraphicClassItemProvider(this);
		}

		return graphicClassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Versions} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VersionsItemProvider versionsItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Versions}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVersionsAdapter() {
		if (versionsItemProvider == null) {
			versionsItemProvider = new VersionsItemProvider(this);
		}

		return versionsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Constraints} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintsItemProvider constraintsItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Constraints}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConstraintsAdapter() {
		if (constraintsItemProvider == null) {
			constraintsItemProvider = new ConstraintsItemProvider(this);
		}

		return constraintsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Connection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionItemProvider connectionItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Connection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConnectionAdapter() {
		if (connectionItemProvider == null) {
			connectionItemProvider = new ConnectionItemProvider(this);
		}

		return connectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.PhysicClass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicClassItemProvider physicClassItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.PhysicClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPhysicClassAdapter() {
		if (physicClassItemProvider == null) {
			physicClassItemProvider = new PhysicClassItemProvider(this);
		}

		return physicClassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.PhysicBody} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicBodyItemProvider physicBodyItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.PhysicBody}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPhysicBodyAdapter() {
		if (physicBodyItemProvider == null) {
			physicBodyItemProvider = new PhysicBodyItemProvider(this);
		}

		return physicBodyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.BitMasks} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BitMasksItemProvider bitMasksItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.BitMasks}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBitMasksAdapter() {
		if (bitMasksItemProvider == null) {
			bitMasksItemProvider = new BitMasksItemProvider(this);
		}

		return bitMasksItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Force} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForceItemProvider forceItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Force}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createForceAdapter() {
		if (forceItemProvider == null) {
			forceItemProvider = new ForceItemProvider(this);
		}

		return forceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.ScoreSystem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScoreSystemItemProvider scoreSystemItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.ScoreSystem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScoreSystemAdapter() {
		if (scoreSystemItemProvider == null) {
			scoreSystemItemProvider = new ScoreSystemItemProvider(this);
		}

		return scoreSystemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Trigger} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TriggerItemProvider triggerItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Trigger}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTriggerAdapter() {
		if (triggerItemProvider == null) {
			triggerItemProvider = new TriggerItemProvider(this);
		}

		return triggerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.PhysicChange} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicChangeItemProvider physicChangeItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.PhysicChange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPhysicChangeAdapter() {
		if (physicChangeItemProvider == null) {
			physicChangeItemProvider = new PhysicChangeItemProvider(this);
		}

		return physicChangeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Collision} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollisionItemProvider collisionItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Collision}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCollisionAdapter() {
		if (collisionItemProvider == null) {
			collisionItemProvider = new CollisionItemProvider(this);
		}

		return collisionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.ObjInit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjInitItemProvider objInitItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.ObjInit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createObjInitAdapter() {
		if (objInitItemProvider == null) {
			objInitItemProvider = new ObjInitItemProvider(this);
		}

		return objInitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.ObjAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjAttributeItemProvider objAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.ObjAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createObjAttributeAdapter() {
		if (objAttributeItemProvider == null) {
			objAttributeItemProvider = new ObjAttributeItemProvider(this);
		}

		return objAttributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Rule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleItemProvider ruleItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Rule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRuleAdapter() {
		if (ruleItemProvider == null) {
			ruleItemProvider = new RuleItemProvider(this);
		}

		return ruleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Not} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotItemProvider notItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Not}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNotAdapter() {
		if (notItemProvider == null) {
			notItemProvider = new NotItemProvider(this);
		}

		return notItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Binary} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryItemProvider binaryItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Binary}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBinaryAdapter() {
		if (binaryItemProvider == null) {
			binaryItemProvider = new BinaryItemProvider(this);
		}

		return binaryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.Arithmetic} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArithmeticItemProvider arithmeticItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.Arithmetic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createArithmeticAdapter() {
		if (arithmeticItemProvider == null) {
			arithmeticItemProvider = new ArithmeticItemProvider(this);
		}

		return arithmeticItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.AttributeValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeValueItemProvider attributeValueItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.AttributeValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeValueAdapter() {
		if (attributeValueItemProvider == null) {
			attributeValueItemProvider = new AttributeValueItemProvider(this);
		}

		return attributeValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.ConstantValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantValueItemProvider constantValueItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.ConstantValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConstantValueAdapter() {
		if (constantValueItemProvider == null) {
			constantValueItemProvider = new ConstantValueItemProvider(this);
		}

		return constantValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link Ardsl.AllInstances} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllInstancesItemProvider allInstancesItemProvider;

	/**
	 * This creates an adapter for a {@link Ardsl.AllInstances}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAllInstancesAdapter() {
		if (allInstancesItemProvider == null) {
			allInstancesItemProvider = new AllInstancesItemProvider(this);
		}

		return allInstancesItemProvider;
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
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
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

		if (parentAdapterFactory != null) {
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
		if (ontologicalItemProvider != null) ontologicalItemProvider.dispose();
		if (graphicItemProvider != null) graphicItemProvider.dispose();
		if (physicItemProvider != null) physicItemProvider.dispose();
		if (gameItemProvider != null) gameItemProvider.dispose();
		if (gamePadItemProvider != null) gamePadItemProvider.dispose();
		if (classItemProvider != null) classItemProvider.dispose();
		if (attributeItemProvider != null) attributeItemProvider.dispose();
		if (referenceItemProvider != null) referenceItemProvider.dispose();
		if (graphicClassItemProvider != null) graphicClassItemProvider.dispose();
		if (versionsItemProvider != null) versionsItemProvider.dispose();
		if (constraintsItemProvider != null) constraintsItemProvider.dispose();
		if (connectionItemProvider != null) connectionItemProvider.dispose();
		if (physicClassItemProvider != null) physicClassItemProvider.dispose();
		if (physicBodyItemProvider != null) physicBodyItemProvider.dispose();
		if (bitMasksItemProvider != null) bitMasksItemProvider.dispose();
		if (forceItemProvider != null) forceItemProvider.dispose();
		if (scoreSystemItemProvider != null) scoreSystemItemProvider.dispose();
		if (triggerItemProvider != null) triggerItemProvider.dispose();
		if (physicChangeItemProvider != null) physicChangeItemProvider.dispose();
		if (collisionItemProvider != null) collisionItemProvider.dispose();
		if (objInitItemProvider != null) objInitItemProvider.dispose();
		if (objAttributeItemProvider != null) objAttributeItemProvider.dispose();
		if (ruleItemProvider != null) ruleItemProvider.dispose();
		if (notItemProvider != null) notItemProvider.dispose();
		if (binaryItemProvider != null) binaryItemProvider.dispose();
		if (arithmeticItemProvider != null) arithmeticItemProvider.dispose();
		if (attributeValueItemProvider != null) attributeValueItemProvider.dispose();
		if (constantValueItemProvider != null) constantValueItemProvider.dispose();
		if (allInstancesItemProvider != null) allInstancesItemProvider.dispose();
	}

}
