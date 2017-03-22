
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Rclass;

@Component
@Transactional
public class RclassToStringConverter implements Converter<Rclass, String> {

	@Override
	public String convert(Rclass rclass) {
		Assert.notNull(rclass);

		String result;

		if (rclass == null) {
			result = null;

		} else {
			result = String.valueOf(rclass.getId());
		}

		return result;
	}
}
