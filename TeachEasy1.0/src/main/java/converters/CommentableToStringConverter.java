
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Commentable;

@Component
@Transactional
public class CommentableToStringConverter implements Converter<Commentable, String> {

	@Override
	public String convert(Commentable commentable) {
		Assert.notNull(commentable);

		String result;

		if (commentable == null) {
			result = null;

		} else {
			result = String.valueOf(commentable.getId());
		}

		return result;
	}
}
