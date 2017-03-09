
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import domain.Curricula;

@Component
@Transactional
public class CurriculaToStringConverter implements Converter<Curricula, String> {

	@Override
	public String convert(Curricula curricula) {
		Assert.notNull(curricula);

		String result;

		if (curricula == null) {
			result = null;

		} else {
			result = String.valueOf(curricula.getId());
		}

		return result;
	}
}
