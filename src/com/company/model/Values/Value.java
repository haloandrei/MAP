package com.company.model.Values;

import com.company.model.Types.Type;

public interface Value {
    Type getType();
    Value deepcopy();
}
