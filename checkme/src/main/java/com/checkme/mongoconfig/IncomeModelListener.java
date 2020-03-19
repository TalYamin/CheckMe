package com.checkme.mongoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.checkme.model.Income;

@Component
public class IncomeModelListener extends AbstractMongoEventListener<Income>{

	
    private SequenceGeneratorService sequenceGenerator;

	
	@Autowired
    public IncomeModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Income> event) {
        if (event.getSource().getIncomeId() < 1) {
            event.getSource().setIncomeId(sequenceGenerator.generateSequence(Income.SEQUENCE_NAME));
        }
    }
	
}
