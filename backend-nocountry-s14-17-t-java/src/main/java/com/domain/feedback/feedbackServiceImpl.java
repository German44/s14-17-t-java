package com.domain.feedback;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.dto.feedbackModel;
import com.domain.feedback.feedback;
import com.domain.feedback.feedbackRepository;
import com.domain.feedback.feedbackService;

@Service
public class feedbackServiceImpl implements feedbackService{

    private final ModelMapper modelMapper;
    private final feedbackRepository feedbackRepository;

    public feedbackServiceImpl(
        ModelMapper modelMapper,
        feedbackRepository feedbackRepository
    ) {
        this.modelMapper = modelMapper;
        this.feedbackRepository = feedbackRepository;
    }

    @Transactional
    @Override
    public feedbackModel createfeedback(feedbackModel feedbackModel) {
        
        feedback feedback = modelMapper.map(feedbackModel, feedback.class);
        feedback = feedbackRepository.save(feedback);
        feedbackModel.setId(feedback.getId());
        return modelMapper.map(feedback, feedbackModel.class);
    }

    @Transactional
    @Override
    public feedbackModel updatefeedback(Long id, feedbackModel feedbackModel) {

        if (feedbackRepository.existsById(id)) {
            feedback feedbackActualizado = modelMapper.map(feedbackModel, feedback.class);
            feedbackRepository.save(feedbackActualizado);
            return feedbackModel;
        }
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "feedback no encontrado para actualizar."
        );
    }

    @Override
    public feedbackModel getfeedbackById(Long id) {

        feedback feedback = feedbackRepository.findById(id).orElse(null);
        if (feedback == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "feedback no encontrado."
            );
        }
        return modelMapper.map(feedback, feedbackModel.class);
    }

    @Override
    public List<feedbackModel> getAllfeedback() {

        List<feedback> entity = feedbackRepository.findAll();
        return entity.stream()
            .map(aux -> modelMapper.map(aux, feedbackModel.class))
            .collect(Collectors.toList());
    }

    @Override
    public void deletefeedback(Long id) {
        if (feedbackRepository.existsById(id)) {
            feedbackRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "feedback no encontrada para eliminar."
            );
        }
    }
}
