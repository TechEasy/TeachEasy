
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.SubjectMatterRepository;
import domain.SubjectMatter;

@Component
@Transactional
public class StringToSubjectMatterConverter implements Converter<String, SubjectMatter> {

	@Autowired
	SubjectMatterRepository	matterRepository;


	@Override
	public SubjectMatter convert(String text) {
		Assert.hasText(text);

		SubjectMatter result;
		int id;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				id = Integer.valueOf(text);
				result = matterRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
