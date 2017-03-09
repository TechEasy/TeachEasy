
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import domain.TimeTable;

@Component
@Transactional
public class TimeTableToStringConverter implements Converter<TimeTable, String> {

	@Override
	public String convert(TimeTable timeTable) {
		Assert.notNull(timeTable);

		String result;

		if (timeTable == null) {
			result = null;

		} else {
			result = String.valueOf(timeTable.getId());
		}

		return result;
	}
}
