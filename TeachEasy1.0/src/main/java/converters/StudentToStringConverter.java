
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import domain.Student;

@Component
@Transactional
public class StudentToStringConverter implements Converter<Student, String> {

	@Override
	public String convert(Student student) {
		Assert.notNull(student);

		String result;

		if (student == null) {
			result = null;

		} else {
			result = String.valueOf(student.getId());
		}

		return result;
	}
}
