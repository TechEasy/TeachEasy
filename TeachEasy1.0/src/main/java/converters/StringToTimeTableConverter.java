
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.TimeTableRepository;
import domain.TimeTable;

@Component
@Transactional
public class StringToTimeTableConverter implements Converter<String, TimeTable> {

	@Autowired
	TimeTableRepository	timeTableRepository;


	@Override
	public TimeTable convert(String text) {
		Assert.hasText(text);

		TimeTable result;
		int id;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				id = Integer.valueOf(text);
				result = timeTableRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
