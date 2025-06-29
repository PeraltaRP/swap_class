package com.ifmt.swap_class.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class DiaSemanaSerializer extends JsonSerializer<DiaSemana> {
    @Override
    public void serialize(DiaSemana dia, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(dia.getDescricao()); // usa "Segunda-feira", etc.
    }
}
