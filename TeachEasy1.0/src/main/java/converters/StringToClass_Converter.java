
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Class_;

@Component
@Transactional
public class StringToClass_Converter implements Converter<String, Class_> {

	@Autowired
	Class_Repository	class_Repository;


	@Override
	public Class_ convert(String text) {
		Assert.hasText(text);

		Class_ result;
		int id;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				id = Integer.valueOf(text);
				result = class_Repository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
