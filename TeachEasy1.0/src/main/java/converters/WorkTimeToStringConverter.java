
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import domain.WorkTime;

@Component
@Transactional
public class WorkTimeToStringConverter implements Converter<WorkTime, String> {

	@Override
	public String convert(WorkTime workTime) {
		Assert.notNull(workTime);

		String result;

		if (workTime == null) {
			result = null;

		} else {
			result = String.valueOf(workTime.getId());
		}

		return result;
	}
}
