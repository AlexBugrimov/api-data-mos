package dev.bug.api.data.mos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "The category not exists")
public class CategoryNotExistsException extends RuntimeException {
}
