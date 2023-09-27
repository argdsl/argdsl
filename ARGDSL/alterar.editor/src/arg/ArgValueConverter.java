package arg;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class ArgValueConverter extends DefaultTerminalConverters {
	@ValueConverter(rule = "AttributeMax")
	public IValueConverter<Integer> AttributeMax() {
		return new IValueConverter<Integer>() {

			@Override
			public Integer toValue(String attr, INode node) throws ValueConverterException {
				if (Strings.isEmpty(attr))
                    throw new ValueConverterException("Attribute cannot be empty", node, null);
                else if ("*".equals(attr.trim()))
                    return -1;
                try {
                    return Integer.parseInt(attr);
                } catch (NumberFormatException e) {
                    throw new ValueConverterException(attr+"' is not number", node, e);
                }
			}

			@Override
			public String toString(Integer attr) throws ValueConverterException {
				 return ((attr == -1) ? "*" : Integer.toString(attr));
			}
		};
	}
	@ValueConverter(rule = "NoLimit")
	public IValueConverter<Integer> NoLimit() {
		return new IValueConverter<Integer>() {

			@Override
			public Integer toValue(String limit, INode node) throws ValueConverterException {
				if (Strings.isEmpty(limit))
                    throw new ValueConverterException("Goal cannot be empty", node, null);
                else if ("*".equals(limit.trim()))
                    return -1;
                try {
                    return Integer.parseInt(limit);
                } catch (NumberFormatException e) {
                    throw new ValueConverterException(limit+"' is not number", node, e);
                }
			}

			@Override
			public String toString(Integer attr) throws ValueConverterException {
				 return ((attr == -1) ? "*" : Integer.toString(attr));
			}
		};
	}
	@ValueConverter(rule = "PosOrCamera")
	public IValueConverter<Double> PosOrCamera() {
		return new IValueConverter<Double>() {

			@Override
			public Double toValue(String attr, INode node) throws ValueConverterException {
				if (Strings.isEmpty(attr))
                    throw new ValueConverterException("Position cannot be empty", node, null);
                else if ("camera".equals(attr.trim()))
                    return 999.0;
                try {
                    return Double.valueOf(attr);
                } catch (NumberFormatException e) {
                    throw new ValueConverterException(attr+"' is not number", node, e);
                }
			}

			@Override
			public String toString(Double value) throws ValueConverterException {
				return ((value == 999.0) ? "camera" : Double.toString(value));
			}
		};
	}
}
