/* Copyright (C) Red Hat 2023-2024 */
package io.opentelemetry.examples.fish;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/fish")
@Produces("text/plain")
public class FishController {
    private static final List<String> FISH = List.of("salmon", "cod", "turbot");

    private final Counter numCombatants;

    private final MeterRegistry registry;

    public FishController(MeterRegistry registry) {
        this.registry = registry;
        this.numCombatants =
                Counter.builder("battles.combatants").tag("type", "fish").register(this.registry);

        new ProcessorMetrics().bindTo(this.registry);
        new JvmMemoryMetrics().bindTo(this.registry);
    }

    @GET
    @Path("/getAnimal")
    public String makeBattle() throws InterruptedException {
        // Random pause
        Thread.sleep((int) (20 * Math.random()));
        numCombatants.increment();
        // Return random fish
        return FISH.get((int) (FISH.size() * Math.random()));
    }
}
