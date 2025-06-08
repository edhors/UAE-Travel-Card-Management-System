package com.demo.travelcardsystem.businessrule;

import com.demo.travelcardsystem.constant.TransportType;
import static com.demo.travelcardsystem.constant.Fares.*;
import com.demo.travelcardsystem.constant.Zone;
import com.demo.travelcardsystem.entity.ZonePair;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;

@Data
@Component
@RequiredArgsConstructor
public class TravelStrategy {

    @NonNull
    private RuleCollection ruleCollection;

    private final DoubleConsumer anyWhereInZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);

        //Create all possible ZonePair for Zone 1
        ZonePair zonePair = new ZonePair(Zone.ONE, Zone.ONE);
        rule.addZonePair(zonePair);

        ruleCollection.addRules(rule);

    };

    private final DoubleConsumer anyOneZoneOutsideZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);

        //create all possible pair of any zone outside zone one.
        rule.addZonePair(new ZonePair(Zone.TWO, Zone.TWO));
        rule.addZonePair(new ZonePair(Zone.THREE, Zone.THREE));

        ruleCollection.addRules(rule);
    };

    private final DoubleConsumer anyTwoZoneIncludingZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);

        //create all possible pair of any zone outside zone one.
        rule.addZonePair(new ZonePair(Zone.ONE, Zone.TWO));
        rule.addZonePair(new ZonePair(Zone.TWO, Zone.ONE));
        rule.addZonePair(new ZonePair(Zone.ONE, Zone.THREE));
        rule.addZonePair(new ZonePair(Zone.THREE, Zone.ONE));

        ruleCollection.addRules(rule);
    };

    private final DoubleConsumer anyTwoZoneExcludingZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);

        //create all possible pair of any two zone excluding zone one.
        rule.addZonePair(new ZonePair(Zone.TWO, Zone.THREE));
        rule.addZonePair(new ZonePair(Zone.THREE, Zone.TWO));

        ruleCollection.addRules(rule);
    };

    private final DoubleConsumer anyThreeZoneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);



        ruleCollection.addRules(rule);
    };

    private final BiConsumer<Double, TransportType> anyJourneyByBus = (chargeableAmount, transType) -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);
        rule.setTransportType(transType);

        ruleCollection.addRules(rule);


    };

    public RuleCollection loadDefaultFareRules() {
        anyWhereInZoneOneStrategy.accept(ZONE_ONE);
        anyOneZoneOutsideZoneOneStrategy.accept(OUTSIDE_ZONE_ONE);
        anyTwoZoneIncludingZoneOneStrategy.accept(TWO_ZONES_WITH_ZONE_ONE);
        anyTwoZoneExcludingZoneOneStrategy.accept(TWO_ZONES_WITHOUT_ZONE_ONE);
        anyThreeZoneStrategy.accept(THREE_ZONES);
        anyJourneyByBus.accept(FARE_BUS, TransportType.BUS);

<<<<<<< Updated upstream
        this.ruleCollection.setMaxFare(7.0);
=======
        this.ruleCollection.setMaxFare(MAX_FARE);
>>>>>>> Stashed changes

        return this.ruleCollection;
    }

}
