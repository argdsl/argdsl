/*
 * generated by Xtext 2.28.0
 */
package arg.ui.tests;

import alterar.editor.ui.internal.EditorActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;

public class ArgUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return EditorActivator.getInstance().getInjector("arg.Arg");
	}

}
