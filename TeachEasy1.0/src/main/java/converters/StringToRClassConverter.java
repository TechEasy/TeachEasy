
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.RClassRepository;
import domain.RClass;

@Component
@Transactional
public class StringToRClassConverter implements Converter<String, RClass> {

	@Autowired
	RClassRepository	rClassRepository;


	@Override
	public RClass convert(String text) {
		Assert.hasText(text);

		RClass result;
		int id;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				id = Integer.valueOf(text);
				result = rClassRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
