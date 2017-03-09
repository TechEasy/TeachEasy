
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Class_;

@Component
@Transactional
public class Class_ToStringConverter implements Converter<Class_, String> {

	@Override
	public String convert(Class_ class_) {
		Assert.notNull(class_);

		String result;

		if (class_ == null) {
			result = null;

		} else {
			result = String.valueOf(class_.getId());
		}

		return result;
	}
}
