
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.RClass;

@Component
@Transactional
public class RClassToStringConverter implements Converter<RClass, String> {

	@Override
	public String convert(RClass rClass) {
		Assert.notNull(rClass);

		String result;

		if (rClass == null) {
			result = null;

		} else {
			result = String.valueOf(rClass.getId());
		}

		return result;
	}
}
