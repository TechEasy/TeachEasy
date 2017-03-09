
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ProposalRepository;
import domain.Proposal;

@Component
@Transactional
public class StringToProposalConverter implements Converter<String, Proposal> {

	@Autowired
	ProposalRepository	proposalRepository;


	@Override
	public Proposal convert(String text) {
		Assert.hasText(text);

		Proposal result;
		int id;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				id = Integer.valueOf(text);
				result = proposalRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
