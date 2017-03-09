
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.TeacherRepository;
import domain.Teacher;

@Component
@Transactional
public class StringToTeacherConverter implements Converter<String, Teacher> {

	@Autowired
	TeacherRepository	teacherRepository;


	@Override
	public Teacher convert(String text) {
		Assert.hasText(text);

		Teacher result;
		int id;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				id = Integer.valueOf(text);
				result = teacherRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
