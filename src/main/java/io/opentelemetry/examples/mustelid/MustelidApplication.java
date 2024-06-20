/* Copyright (C) Red Hat 2023-2024 */
package io.opentelemetry.examples.mustelid;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain(name = "MustelidApplication")
public class MustelidApplication {

    public static void main(String... args) {
        Quarkus.run(args);
    }
}
