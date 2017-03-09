
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import domain.Teacher;

@Component
@Transactional
public class TeacherToStringConverter implements Converter<Teacher, String> {

	@Override
	public String convert(Teacher teacher) {
		Assert.notNull(teacher);

		String result;

		if (teacher == null) {
			result = null;

		} else {
			result = String.valueOf(teacher.getId());
		}

		return result;
	}
}
