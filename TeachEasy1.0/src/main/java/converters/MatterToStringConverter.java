
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import domain.Matter;

@Component
@Transactional
public class MatterToStringConverter implements Converter<Matter, String> {

	@Override
	public String convert(Matter matter) {
		Assert.notNull(matter);

		String result;

		if (matter == null) {
			result = null;

		} else {
			result = String.valueOf(matter.getId());
		}

		return result;
	}
}
