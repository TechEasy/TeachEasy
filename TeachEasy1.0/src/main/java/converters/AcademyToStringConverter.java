
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Academy;

@Component
@Transactional
public class AcademyToStringConverter implements Converter<Academy, String> {

	@Override
	public String convert(Academy academy) {
		Assert.notNull(academy);

		String result;

		if (academy == null) {
			result = null;

		} else {
			result = String.valueOf(academy.getId());
		}

		return result;
	}
}
