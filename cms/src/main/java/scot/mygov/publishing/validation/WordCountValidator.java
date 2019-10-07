package scot.mygov.publishing.validation;

import org.onehippo.cms.services.validation.api.ValidationContext;
import org.onehippo.cms.services.validation.api.ValidationContextException;
import org.onehippo.cms.services.validation.api.Validator;
import org.onehippo.cms.services.validation.api.Violation;

import javax.jcr.Node;
import java.util.*;

/**
 * Used to validate fields to check if they have a minimum and maximum nuber of words.
 */
public class WordCountValidator implements Validator<String> {

    static final String WORK_COUNT_MIN_KEY = "wordcount.min";

    static final String WORK_COUNT_MAX_KEY = "wordcount.max";

    private int minWordCount = -1;

    private int maxWordCount = -1;

    public WordCountValidator(Node config) {
        minWordCount = ValidatorUtil.getIntegerPropertyFromConfig(config, WORK_COUNT_MIN_KEY);
        maxWordCount = ValidatorUtil.getIntegerPropertyFromConfig(config, WORK_COUNT_MAX_KEY);
        if (minWordCount < 0) {
            throw new ValidationContextException(WORK_COUNT_MIN_KEY + " must be >= 0");
        }

        if (maxWordCount < minWordCount) {
            throw new ValidationContextException(WORK_COUNT_MAX_KEY + " must be > " + WORK_COUNT_MIN_KEY);
        }
    }

    public Optional<Violation> validate(ValidationContext context, String value) {
        int wordCount = value != null ? value.split("\\s+").length : 0;
        if (wordCount > maxWordCount || wordCount < minWordCount) {
            Map<String, String> params = new HashMap<>();
            params.put(WORK_COUNT_MAX_KEY, Integer.toString(maxWordCount));
            params.put(WORK_COUNT_MIN_KEY, Integer.toString(minWordCount));
            return Optional.of(context.createViolation(params));
        } else {
            return Optional.empty();
        }
    }
}
