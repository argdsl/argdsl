package alterar.plugin;

import alterar.acceleo.main.Generate;
import arg.ArgStandaloneSetup;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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

public class AlterarPlugin extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
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
		 Resource resource = rs.createResource(URI.createURI(file.getRawLocationURI().toString()));
		 resource.load(null);
		 // perform action
		 
		//Generating xmi
		 String input = resource.getURI().toString();
		 String outputXmi = resource.getURI().toString().replaceAll(resource.getURI().lastSegment(), "")+resource.getURI().lastSegment().replaceAll(".arg", ".xmi");
		 ArgStandaloneSetup.argToXmi(input, outputXmi);
		 
		 //Generating code with Acceleo	
		 String inputXmi =  file.getLocation().toString().replaceAll(file.getLocation().lastSegment(), "")+file.getLocation().lastSegment().replaceAll(".arg", ".xmi");
		 String output = file.getLocation().toString().replaceAll(file.getLocation().lastSegment(),"")+file.getLocation().lastSegment().replaceAll(".arg", "");
		 Generate generateAcceleo = new alterar.acceleo.main.Generate();
		 generateAcceleo.doGeneratePlugin(inputXmi, output);
		 
		MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindowChecked(event).getShell(),
		"Code generated",
		"Code generated ");
		 }
		 catch (Exception e) {}
		 return Status.OK;

	}

}
