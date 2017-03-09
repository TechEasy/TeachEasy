
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import domain.Day;

@Component
@Transactional
public class DayToStringConverter implements Converter<Day, String> {

	@Override
	public String convert(Day day) {
		Assert.notNull(day);

		String result;

		if (day == null) {
			result = null;

		} else {
			result = String.valueOf(day.getId());
		}

		return result;
	}
}
