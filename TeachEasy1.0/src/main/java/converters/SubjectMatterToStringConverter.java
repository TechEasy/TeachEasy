
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import domain.SubjectMatter;

@Component
@Transactional
public class SubjectMatterToStringConverter implements Converter<SubjectMatter, String> {

	@Override
	public String convert(SubjectMatter matter) {
		Assert.notNull(matter);

		String result;

		if (matter == null) {
			result = null;

		} else {
			result = String.valueOf(matter.getId());
		}

		return result;
	}
}
