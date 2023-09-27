package alterar.pluginPost;


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;



public class AlterarPost extends AbstractHandler {

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
		 MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindowChecked(event).getShell(),
				 file.getName(),
				 file.getName());
		 
		 // perform action
		 try {
			 	String x = new String(file.getContents().readAllBytes(), StandardCharsets.UTF_8);
				URL url = new URL("https://alter-server.onrender.com/jsonOntological");
				if(file.getName().contains("graphic")) {
					url = new URL("https://alter-server.onrender.com/jsonGraphic");
				} else if(file.getName().contains("physic")) {
					url = new URL("https://alter-server.onrender.com/jsonPhysic");
				} else if(file.getName().contains("gameloop")) {
					url = new URL("https://alter-server.onrender.com/jsonGameloop");
				}
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setRequestProperty("Accept", "application/json");
				con.setDoOutput(true);
				byte[] input = x.getBytes("utf-8");
				OutputStream os = con.getOutputStream();
			    os.write(input, 0, input.length);
			    os.flush();
				os.close();
				// For POST only - END

				int responseCode = con.getResponseCode();
				System.out.println("POST Response Code :: " + responseCode);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 } catch (Exception e) {
			 System.out.println(e);
		 }
		 return Status.OK;
	}
}
