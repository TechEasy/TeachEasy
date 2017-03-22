
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.RClassRepository;
import domain.Rclass;

@Component
@Transactional
public class StringToRClassConverter implements Converter<String, Rclass> {

	@Autowired
	RClassRepository	rClassRepository;


	@Override
	public Rclass convert(String text) {
		Assert.hasText(text);

		Rclass result;
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
