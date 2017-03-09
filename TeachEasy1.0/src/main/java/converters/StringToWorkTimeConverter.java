
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.WorkTimeRepository;
import domain.WorkTime;

@Component
@Transactional
public class StringToWorkTimeConverter implements Converter<String, WorkTime> {

	@Autowired
	WorkTimeRepository	workTimeRepository;


	@Override
	public WorkTime convert(String text) {
		Assert.hasText(text);

		WorkTime result;
		int id;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				id = Integer.valueOf(text);
				result = workTimeRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
