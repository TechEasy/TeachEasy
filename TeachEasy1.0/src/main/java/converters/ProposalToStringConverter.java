
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import domain.Proposal;

@Component
@Transactional
public class ProposalToStringConverter implements Converter<Proposal, String> {

	@Override
	public String convert(Proposal proposal) {
		Assert.notNull(proposal);

		String result;

		if (proposal == null) {
			result = null;

		} else {
			result = String.valueOf(proposal.getId());
		}

		return result;
	}
}
