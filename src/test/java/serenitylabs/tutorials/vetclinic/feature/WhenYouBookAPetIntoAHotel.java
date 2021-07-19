package serenitylabs.tutorials.vetclinic.feature;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.questions.TheRegisteredGuests;
import serenitylabs.tutorials.vetclinic.tasks.CheckIn;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

@RunWith(SerenityRunner.class)
public class WhenYouBookAPetIntoAHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel(){

        //GIVEN
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel Carlifonia");

        //WHEN
        petra.attemptsTo(
                CheckIn.APet(ginger).into(petHotel)
                //new CheckIn(ginger,petHotel)
        );


        //THEN
        //assertThat(petHotel.getPets(),hasItems(ginger));
        petra.should(seeThat(TheRegisteredGuests.in(petHotel),hasItem(ginger)));

    }
}
