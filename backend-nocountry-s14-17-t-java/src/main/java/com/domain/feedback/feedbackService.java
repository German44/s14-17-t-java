package com.domain.feedback;

import java.util.List;
import com.dto.feedbackModel;

public interface feedbackService {

    feedbackModel createfeedback(feedbackModel feedbackModel);
    feedbackModel updatefeedback(Long feedbackId, feedbackModel feedbackModel);

    feedbackModel getfeedbackById(Long id);
    List<feedbackModel> getAllfeedback();

    void deletefeedback(Long feedbackId);
}
