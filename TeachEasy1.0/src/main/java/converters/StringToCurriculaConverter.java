
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Curricula;

@Component
@Transactional
public class StringToCurriculaConverter implements Converter<String, Curricula> {

	@Autowired
	CurriculaRepository	curriculaRepository;


	@Override
	public Curricula convert(String text) {
		Assert.hasText(text);

		Curricula result;
		int id;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				id = Integer.valueOf(text);
				result = curriculaRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
