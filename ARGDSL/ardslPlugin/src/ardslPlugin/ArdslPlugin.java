package ardslPlugin;

import ardsl.ArdslStandaloneSetup;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class ArdslPlugin extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) {
	 // obtain selected file
	 IFile file = null;
	 ISelection selection = HandlerUtil.getCurrentSelection(event);
	 if (selection instanceof IStructuredSelection) {
	 Object first = ((IStructuredSelection)selection).getFirstElement();
	 file = (IFile)Platform.getAdapterManager().getAdapter(first, IFile.class);
	 if (file == null)
	 if (first instanceof IAdaptable)
	 file = (IFile)((IAdaptable)first).getAdapter(IFile.class);
	 }
	 try {
	 // load selected file in a resource
	 ResourceSet rs = new ResourceSetImpl();
	 Resource resource = (Resource) rs.createResource(URI.createURI(file.getRawLocationURI().toString()));	 
	 // perform action
	 
	 //Generating xmi
	 String input = resource.getURI().toString();
	 String outputXmi = resource.getURI().toString().replaceAll(resource.getURI().lastSegment(), "")+resource.getURI().lastSegment().replaceAll(".ardsl", ".xmi");
	 ArdslStandaloneSetup.ardslToXmi(input, outputXmi);
	 
	// perform action
	 MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindowChecked(event).getShell(),
	 "Generate Code",
	 "Generate Code");
	 
	 } catch (Exception e) {
		 System.out.println(e);
	 }
	 return Status.OK;
	}
}
