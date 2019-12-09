package com.coreelements.ihnn;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.google.android.gms.ads.*;

import java.util.ArrayList;
import java.util.List;
//import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class GameActivity extends ActionBarActivity implements View.OnClickListener {

    ImageButton next_btn;
    private SharedPreferences speicher;
    private SharedPreferences.Editor editor;

    List<String> Fragen = new ArrayList<String>();
    ArrayAdapter<String> FragenAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        AdView adViewUP = (AdView)findViewById(R.id.adViewUP);
        AdRequest adRequestUP = new AdRequest.Builder().build();
        adViewUP.loadAd(adRequestUP);

        FragenAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Fragen);

        //AdBuddiz.setPublisherKey("73489c9d-5cab-4fd6-a591-3e09af48f152");
        //AdBuddiz.cacheAds(this);
        //AdBuddiz.showAd(this);

        next_btn = (ImageButton)findViewById(R.id.next_btn2);
        next_btn.setOnClickListener(this);

        speicher = getApplicationContext().getSharedPreferences("Daten", 0);
        editor = speicher.edit();

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("Achtung");
        alertDialog.setMessage("Wir haften nicht für Schäden. Weder für psychische-, körpeliche- oder sachliche Schäden. Also passen Sie auf und hören Sie auf zu trinken bevor es zu viel wird :D");
        alertDialog.setIcon(R.drawable.alert_dialog_icon);
        alertDialog.setPositiveButton("Alles Klar!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Dann viel Spaß! :D", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
        addQuestions();

    }
    
    public void addQuestions(){
        final String[] aufgaben = {"vor Freunden in die Hose gepinkelt", "ein Pizza-Eis gegessen", "ins Bett gekackt", "einen der Mitspieler geküsst", "meinen eigenen Namen gegoogelt",
                "jemanden beim Sex beobachtet", "eine Beziehung die ich früher hatte geleugnet", "versehentlich als ich ich auf dem Klo war die Tür offen gelassen",
                "komplett nackt geschlafen", "für eine deutlich ältere Person geschwärmt",
                //10
                "Einen falschen Namen im Internet benutzt", "nach dem Geschäft etwas anderes als Klopapier zum abwischen benutzt",
                "jemanden gestalked", "mit einer echten Schusswaffe geschossen", "eine Person gleichen Geschlechts geküsst",
                "ein Striplocal von innen gesehen", "ein bereits fertiges Referat besorgt, und es dann in der Schule vorgetragen",
                "so doll gelacht, dass ich pinkeln musste", "eine Arbeit geschrieben, für die ich weniger als eine Stunde gelernt hatte", "einen ganzen Tag lang Videospiele gespielt",
                //20
                "einen ganzen Tag lang gelesen", "eine erotische digitale Nachricht verschickt", "mit meinen Eltern über Verhütung gesprochen", "einen Autounfall gehabt",
                "einen Strafzettel bekommen", "nach einem Friseurbesuch gedacht: Hätte ich doch lieber die vorherige Frisur gelassen", "einem Freund/einer Freundin Kacke vom Fuß/vom Schuh gekratzt",
                "den Wunsch gehabt älter zu sein", "den Wunsch gehabt jünger zu sein", "mit mehr als einer Person gleichzeitig eine Beziehung oder eine Affäre gehabt",
                //30
                "im Internet nach Nacktbildern einer prominenten Person gesucht", "gewünscht, dass die Eltern eines Freundes meine Eltern wären",
                //32
                "mehr als eine Woche im Krankenhaus verbracht", "einen Brief in den Briefkasten geworfen und danach versuch ihn wieder raus zu holen",
                "meinen festen Freund/meine feste Freundin mit dem Namen meiner/meines Ex angesprochen", "auf einer Hochzeit gedacht, dass diese Ehe nicht lange halten wird",
                "eine Fehrnbeziehung gehabt", "an meinen Fingernägeln gekaut", "an den Fingernägeln einer anderen Person gekaut",
                //39
                "jemand anderem das Herz gebrochen", "eine Zigarre geraucht", "eine Zigarette geraucht", "eine Shisha geraucht", "Drogen genommen", "in der Öffentlichkeit in die Hose gepinkelt",
                "jemanden beim Masturbieren erwischt", "etwas kaputt gemacht, um mich an jemandem zu rächen", "gewünscht, dass ich wieder ein kleines Baby wäre",
                "überlegt mir ein Tattoo stechen zu lassen",
                //49
                "betrunken Nachrichten versendet, die ich nachher bereut habe", "einen Fallschirmsprung gemacht", "meine Eltern gefragt, wo genau ich gezeugt wurde",
                "einen Film häufiger als 10 mal gesehen", "bei einem Film geweint", "einer fremden Person einfach so auf den Hintern gehauen", "meinen Kopf kahl geschoren",
                "in den Spiegel geschaut und gedacht: Man seh ich gut aus!", "von jemandem ein erotisches Geschenk bekommen", "jemandem die Füße geküsst",
                //59
                "telefoniert während ich auf dem KLo saß", "gechattet während ich auf dem Klo saß", "einen Freund/eine Freundin gehabt, dessen Eltern mich nicht leiden konnten",
                "etwas gegessen, dessen Haltbarkeitsdatum schon abgelaufen war", "Geld gefunden und es behalten", "das Geheimnis eines Freundes ausgeplaudert(versehentlich oder absichtlich)",
                "als ich von irgendwo wütend weg gestürmt bin gedacht: Hoffentlich hält mich jemand auf!", "ein Freizügiges Bild über SnapChat verschickt", "hinter dem Kühlschrank sauber gemacht",
                "einen Bungee-Sprung gemacht",
                //69
                "einen Liebesbrief geschrieben", "einen Liebesbrief an mich selbst geschrieben", "einen erotischen Brief versendet", "mit jemandem schluss gemacht", "erotische Fotos von mir gemacht/machen lassen",
                "einen Schwangerschaftstest gekauft", "wo anders als zu Hause masturbiert", "hinter seinem/ihren Rücken schlecht über meinen Partner geredet", "beim Aufwachen gedacht: Wer ist das neben mir?",
                "für erotische Dienstleistungen bezahlt",
                //79
                "Sex in einem Auto gehabt", "Sex in oder auf einem anderen Verkehrsmittel als einem Auto gehabt", "etwas mit einem Wert von über 500€ kaputt gemacht, oder es verloren",
                "bei einem Treffen bezüglich meines Alters oder meiner Herkunft gelogen", "etwas besessen; dass ich immer versteckt habe wenn Freunde zu Besuch kamen",
                "meine Eltern beim Sex gehört", "meine Nachbarn beim Sex gehört", "den Notruf gewählt", "einen Rausschmiss in einem Club bekommen", "Nachts im Gras geschlafen",
                //89
                "Sternschnuppen beobachtet", "Sex an einem sehr ungewöhnlichen Ort gehabt", "irgendetwas auf jemand anderen geschoben, nur um nicht zugeben zu müssen, dass ich es gewesen bin",
                "einen A-Promi persönlich getroffen", "einen Porno gedreht", "so getan als würde ich vor einem Millionenpublikum stehen und singen", "so getan als wäre ich ein Topmodel",
                "versucht das Passwort eines Anderen zu erraten", "mit dem Schluss machen gewartet, weil ich noch niemand Neues hatte", "jemanden für mich strippen lassen",
                "eine private Nachricht an den falschen Empfänger gesendet",
                //100
                "eine Hochtzeitsrede gehalten", "das Gefühl gehabt egoistisch zu sein", "einem Fremden auf der Straße geholfen", "etwas geklaut", "etwas im Internet bestellt weil ich mich nicht getraut habe es im Laden zu kaufen",
                "einen Abend ohne Freunde oder Bekannte in einem Club verbracht", "jemanden geküsst und es danach bereut", "einen Partner gehabt bei dem ich Angst hatte ihn meinem Eltern vorzustellen",
                "jemandem ein falsches Alter gesagt um ihn Näher kennen zu lernen", "einem Ex-Partner schwere Beleidigungen bei der Trennung an den Kopf geworfen",
                //110
                "Flaschendrehen mit zweideutigen oder intimen Aufgaben gespielt", " in öffentlichen Verkehrsmitteln absichtlich den Platz gewechselt um neben einer attraktiven Person zu sitzen",
                "Tierfutter probiert", "Muskelkater gehabt", "einen Knochenbruch gehabt", "besoffen ein Geheimnis ausgeplaudert", "behauptet, dass ich single bin obwohl ich in einer Beziehung war",
                "eine Mutprobe mitgemacht", "einen Spiegel benutzt, um meine Intimzonen genauer zu betrachten", "das Gefühl gehabt mit meinem Körper komplett zufrieden zu sein",
                //120
                "um Sex gebettelt", "meinem Intimbereich einen Spitznamen gegeben", "meinen Intimbereich vermessen", "bei einer Arbeit/Prüfung abgeschrieben", "versaute Sachen gesagt um jemanden scharf zu machen",
                "für meinen besten Freund/meine beste Freundin gelogen", "den Geburtstag eines Familienangehörigen vergessen", "das es mir Schlecht geht, um Frei zu kriegen", "jemandem die Füße massiert", "jemanden massiert",
                //130
                "jemandem das Leben gerettet", "bei einem Horrorfilm vor Angst geschrien", "auf eine andere Person gekotzt", "eine andere Person angepinkelt", "eine andere Person angeniest", "alleine zu Hause so viel getrunken, dass ich betrunkenn war",
                "eine Beziehung gehabt bei der ich immer im Hinterkopf hatte: Das wird sowieso nicht lange halten", "meinen Chef angeschrien", "privat mit meinem Chef/Lehrer geschrieben", "einen wichtigen Menschen verloren",
                //140
                "heimlich unter dem Tisch Händchen gehalten", "geheuelt während mein Freund/meine Freundin anwesend war", "mit Freunden Pornos geguckt", "mit meinem festen Freund/meiner festen Freundin einen Porno geguckt",
                "mehr als 200€ an einem Abend ausgegeben", "ein Kleidungsstück mit einem Wert von über 200€ gekauft", "erotische Dinge gekauft", "jemanden gedated der ziemlich eigenartig war", "jemandem gedated der wie ein Mörder wirkte",
                "einen Bekannten auf der Straße gesehen, und so getan als hätte ich ihn nicht gesehen",
                //150
                "gesehen wie einem Fremden auf der Straße etwas schlimmes passiert ist und laut los gelacht", "Pornos geguckt und und jemand kam rein", "auf einer Party Sex gehabt", "Massageöl benutzt", "mit einem Freund/einer Freundin über sexuelle Wünsche/Fantasien geredet",
                "überlegt, ob ich nicht das Ufer wechseln soll", "übelegt wie ein Lehrer/Vorgesetzter wohl nackt aussieht", "beim Masturbieren jemanden zuschauen lassen", "ein angebot für Sex abgelehnt", "eine Frisur gehabt, für die ich mich heute schämen würde",
                //160
                "die Anfrage eines Lehrers/Vorgesetzten auf einem sozialen Netzwerk ignoriert", "ausgenutzt, dass jemand total betrunken war", "einen Neujahrsvorsatz eingehalten", "Bilder/Videos auf meinem Computer versteckt",
                "ein MMO gesuchtet", "getan als ob ich kein Geld dabei hatte, weil ich für etwas nicht bezahlen wollte", "in der öffentlichkeit eine attraktive Person angesprochen", "einen Heiratsantrag gemacht",
                "einen Heiratsantrag in der Öffentlichkeit gemacht", "eine erotische Massage gegeben oder bekommen",
                //170
                "Sex in einer Badewanne gehabt", "unter der Dusche gesungen", "geleugnet, dass ich unter der Dusche gesungen hab", "mit jemandem rum gemacht dessen Vornamen ich nicht kannte", "mich selbst gestreichelt und so getan als wäre es jemand anderes",
                "Lust gehabt mit einem der Mitspieler zu schlafen", "gedacht, dass mein Freund/meine Freundin besser aussieht als ich", "einen lautstarken Streit in der Öffentlichkeit gehabt", "einen Knutschfleck gehabt", "mit mir selber gekuschelt",
                //180
                "mit jemandem aus einem anderen Land rumgemacht", "außerhalb von zu Hause nackt gebadet", "außerhalb von zu Hause nackt geschlafen", "erlebt, dass ein Haustier eine Hausaufgabe gefressen hat",
                "so eine Wut gehabt, dass ich jemanden verprügelt habe", "in öffentlichen Verkehrsmitteln mit jemandem rum gemacht", "behauptet, dass ich gut im Bett bin", "Dinge in einem Sexshop eingekauft",
                "ein Bad mit schaum genommen", "Disneyland oder Disneyworld besucht",
                //190
                "ein Legoland besucht", "einen Freizeitpark besucht", "eine ganze Chilischote gegessen", "gemeinsam mit meinem Partner geduscht oder gebadet", "gekifft", "versucht mich mit einem Staubsauger zu befriedigen",
                "Silikonbrüste berührt", "hunderte Kilometer zurück gelegt nur um einen bestimmten Menschen zu besuchen", "in einem Raum verweilt, indem andere Sex hatten", "meinen Intimbereich fotografiert",
                //200
                "ein  Verkehrsschild umgestoßen/umgefahren", "meinen besten Freund/meine beste Freundin nackt gesehen", "den Wunsch gehabt einfach abzuhauen", "den Wunsch gehabt in eine andere Stadt zu ziehen",
                "so viel Angst gehabt, dass ich am ganzen Körper gezittert habe", "versucht mit Falschgeld zu bezahlen", "bei einem Dreier mitgemacht", "ein Tier auf den Mund geküsst", "für die Eltern eines Freundes/einer Freundin geschwärmt",
                "24 Stunden lang den Fernseher laufen lassen",
                //210
                "etwas außergewöhnlich ekliges gegessen", "meinen Hintern kopiert", "ein Speed-Date gehabt", "bei Klamotten das Preisschild dran gelassen um es nach dem Tragen wieder zurück zu geben",
                "das Etikett oder Logo eines Kleidungsstücks entfernt, weil es von einer Billigmarke war", "mehr als 100€ für ein Taxi ausgegeben", "bei einem Buch die letzte Seite zuerst gelesen",
                "versucht den G-Punkt zu finden", "einen Ladendiebstahl beobachtet", "etwas auf der Arbeit geklaut",
                //220
                "ein Partyspiel gespielt bei dem es auch ums ausziehen ging", "heimlich das Getränk eines anderen ausgetrunken", "Geld von meinen Eltern geklaut", "Bilder meines Ex-Partners ins Internet gestellt",
                "die Schule geschwänzt", "ein sehr peinliches Rollenspiel mitgemacht", "einen Liebesbrief bekommen", "gesagt ich bin homosexuell, um in Ruhe gelassen zu werden", "jemandem etwas anderes als Post in den briefkasten gesteckt",
                "so laut gestöhnt dass ich Angst hatte jemand anderes könnte es gehört haben",
                //230
                "gehofft, dass man mein Magenknurren nicht gehört hat", "einen Nieser unterdrückt", "eine Party erst am Morgen des nächsten Tages verlassen", "die Minibar in einem Hotel komplett geleert",
                "eine Schlange gehalten", "einen Hamster im Klo runter gespült", "aufgrund eines Katers die Schule/die Arbeit geschwänzt", "an einem Casting teilgenommen", "nackt vor dem Computer gesessen", "jemandem ein Kompliment gemacht",
                //240
                "eine Straftat begangen", "Pornohefte gekauft", "mit einer Person geflirtet, obwohl ich wusste dass diese Person vergeben ist", "einen Tag lang nur im Schlafanzug verbracht", "länger als 3 Tage lang nicht geduscht",
                "meinen Partner betrogen", "erlebt, von der Polizei durchsucht zu werden", "erlebt, dass die Polizei mich für eine Straftat festgenommen hat (fälschlicherweise oder berechtigt)",
                "eine zweideutige Situation absichtlich falsch gedeutet", "den Namen eines bekannten vergessen, als ich mit ihn geredet habe",
                //250
                "in der Sauna andere Leute beobachtet", "den Wunsch gehabt mein Geschlecht zu wechseln", "Gleitmittel benutzt", "eine E-Mail Adresse angelegt, die ich benutzte wenn ich anonym bleiben will", "Esspapier gegessen",
                "eine übles Gerücht über jemanden in die Welt gesetzt", "hinter seinem/ihrem Rücken über meinen besten Freund/meine beste Freundin gelästert", "gehofft, dass mich eine bestimmte Person nicht anspricht",
                "mein Gesicht kopiert", "mehr als 48 Stunden ohne Schlaf verbracht",
                //260
                "ein Buch gelesen das mich angeturnt hat", "Strippoker gespielt", "meinen Flug verpasst", "meinen Zug verpasst", "den falschen Flug genommen", "den falschen Zug genommen", "nackt ein Verkehrsmittel gefahren",
                "einen ganzen Tag im Bett gelegen", "in einem Kinofilm geschlafen", "einem Kinofilm rumgemacht",
                //270
                "während eines Wutanfalls etwas zerstört", "während einem Date eine Ausrede benutzt, um es frühzeitig zu beenden", "einem anderen Autofahrer den Stinkefinger gezeigt", "nackt in einem See/einem Meer gebadet",
                "eine Beerdigung besucht", "eine Frage bei einem Trinkspiel falsch beantwortet", "Fantasien gehabt, für die ich mich schäme", "einen Käfer gegessen", "einen Tag lang keine Unterwäsche getragen",
                "ein Bordell besucht",
                //280
                "so getan als wäre ich betrunken", "bei Bekannten in den Badezimmerschrank geguckt", "so viel getrunken, dass ich den Weg nach Hause nicht mehr gefunden habe", "über den Tod nachgedacht habe",
                "ein Liebesgedicht geschrieben", "ein Gedicht geschrieben", "meinen Eltern erzählen müssen ob ich noch Jungfrau bin", "das Kamasutra \"gelsesen\"", "jemanden durch eine Wand oder eine Tür belauscht",
                "Eifersucht gegenüber meinem Partner verspürt",
                //290
                "Telefonsex gehabt", "beim Aufwachen gedacht: Wo bin ich denn hier?", "gehofft, dass niemand meinen Furz gehört hat", "zu meinem Exfreund/Exfreundin gesagt: Lass uns Freunde bleiben",
                "einen Swingerclub von innen gesehen", "für jemanden gestrippt", "einen Tabledance gemacht", "etwas aus einem Hotel mitgehen lassen", "ein anderes Fahrzeug beschädigt und bin dann einfach abgehauen",
                "geweint bis ich eingeschlafen bin",
                //300
                "ein Sextape gemacht", "eine Schwarzfahrt gemacht", "erotische Bilder/Kalender aufgehängt", "jemanden heimlich beobachtet", "über einen Freund gedacht dass seine Eltern bei der Erziehung versagt haben",
                "eine Tablette ganz verschluckt", "Viagra genommen", "mehrere Stunden am Stück ohne Kleidung verbracht", "einen Dildo für etwas anderes als zur Selbstbefriedigung benutzt", "Silikonbrüste getragen",
                //310
                "Essensreste in meinem Bett gefunden", "etwas besser gekonnt als alle meine Freunde", "Kondome gekauft", "Handschellen am Armgelenk getragen", "Handschellen am Fußgelenk getragen",
                "Pfeife geraucht", "aufrgund einer Verletzung in einem Krankenwagen gelegen", "in den persönlichen Dateien auf einem fremden Computer gestöbert", "in den persönlichen Dateien in einem fremden Handy gestöbert",
                "ein Insekt mit Absicht getötet",
                //320
                "ein Fahrrad geklaut", "einen Fahrradsattel in meinem Hintern stecken gehabt", "den Geburtstag von einer wichtigen Person in meinem Leben vergessen", "ein Geschenk vergessen",
                "drei Nächte hintereinander durchgefeiert", "jemanden in einer zweideutigen Situation erwischt", "ein Wort gegoogelt, weil ich nicht wusste wie man es schreibt", "mit einem fremden Auto einen Unfall gehabt",
                "etwas in einem Laden genommen und kurz vor der Kasse einfach irgendwo hin gelegt, weil ich es doch nicht mehr kaufen wollte", "erlebt, dass ich in einem Laden von der Ladenpolizei festgenommen wurde",
                //330
                "einen Tanger getragen", "über Sex getraümt", "jemanden nach seiner Telefonnummer gefragt und ihn dann nie angerufen", "schlafgewandelt", "Sex im Bett meiner Eltern gehabt", "vor der Polizei fliehen müssen",
                "Kängurufleisch gegessen", "eine Zahnspange getragen", "meinen Chef/Lehrer angeschrien", "den Wunsch gehabt, unsichtbar zu sein",
                //340
                "einen Korb bekommen", "Schadenfreude verspürt als ich hörte, dass einem anderen etwas schlimmes zugestoßen ist", "darüber nachgedacht, was nach dem Tod passieren wird",
                "ein Telefonat geführt, dass länger als 3 Stunden gedauert hat", "meinen Geburtstag vergessen", "heimlich meine Nachbarn beobachtet", "in die Dusche gepinkelt", "eine Schlägerei provoziert",
                "meinen Chef/Lehrer beleidigt", "Walfleisch gegessen",
                //350
                "einen Rap geschrieben", "ein Buch verfasst", "Tagebuch geschrieben", "ein Tagebuch angefangen, dann aber wieder aufgehört weil ich zu faul war", "einen Furz angezündet", "Vogelkacke ab bekommen",
                "Dirty Dancing geguckt", "einen Harry Potter Buch gelesen", "Sperma geschluckt", "im Dunkeln Angst gehabt",
                //360
                "einen Schneeball geworfen", "einen Schneemann gebaut", "einen Biss von einem Tier bekommen", "einen Biss von einem Menschen bekommen", "mein Urin getrunken", "den Urin eines anderen getrunken",
                "in einem Aufzug gefurzt", "versucht das ABC zu rülpsen", "einem Freund etwas Schlechtes gewünscht", "eine Ehe zerstört",
                //370
                "eine Beziehung zerstört", "Bilder oder Videos auf meinem PC/Handy versteckt", "ins Schwimmbad gepinkelt", "auf eine Auffahrt gekackt", "ein Auto aus Wut getreten", "einem Auto einen Schlüsselkratzer verpasst",
                "den Penis eines Nilpferdes gesehen", "ins Waschbecken gepinkelt", "im Hotel Fernsehen geguckt", "selber Reifen gewechselt",
                //380
                "Gras geraucht", "etwas sehr Dummes gemacht", "einen Schwulenporno geguckt", "eine Operation gehabt", "meine eigenen Haare geschnitten", "meine eigene Brustwarze abgeleckt",
                "meinen Ellenbogen abgeleckt", "meinen Fuß abgeleckt", "gesagt, dass die Verbidung schlecht ist um ein Telefonat vorzeitig zu beenden", "Blut gespendet",
                //390
                "Blut geleckt", "einen Herzinfarkt gehabt", "meinen Wecker gegen die Wand geworfen", "meinen Wecker kaputt gemacht", "mein Handy kaputt gemacht", "mein Handy zerbrochen", "in einer Fußballmannchaft gespielt",
                "jemanden bei einem sozialen Netzwerk blockiert", "ein Haustier gehabt", "für einen Freund gelogen",
                //400
                "etwas auf YouPorn geguckt", "ein YouTube Video angesehen", "ein Video auf YouTube hoch geladen", "die selbe Unterhose mehr als 3 Tage hintereinander getragen, ohne sie zu waschen", "nicht biologisch abbaubaren Müll in die Natur geworfen",
                "ein Kasino besucht", "im Lotto gewonnen", "mein Handy runter fallen lassen", "Sozialarbeit geleistet", "aufgrund einer Spinne geschrien",
                //410
                "ein Tier gequält", "einen Spaziergang Nachts im Wald gemacht", "eine Hausparty gemacht", "eine Kirsche und eine Banane gleichzeitig gegessen", "eine Diät gemacht", "Gras gegessen", "ein Fahrrad betrunken gefahren",
                "den Weg durch die Hecke genommen", "einen Frosch geküsst", "die Pixel eines Bildschirmes gezählt",
                //420
                "versucht mir in den Hintern zu treten", "die Abkürzung genommen und bin trotzdem zu spät gekommen", "meine Nägel lackiert", "in einem privaten Whirlpool gesessen", "versucht jemanden eifersüchtig zu machen",
                "einen Rausschmiss bei McDonald's bekommen", "bei KFC gegessen", "ein Erbeermarmeladebrot mit Honig gegessen", "erlebt, dass ich oder jemand anders auf einer Banane/Bananenschale ausgerutscht ist",
                "Lasertag gespielt",
                //430
                "den YAHOO Browser benutzt", "Kotze runter geschluckt", "Papier gegessen", "ein Stipendium bekommen", "irgendeine Sache aus diesem Spiel gemacht, nur um beim nächsten spielen sagen zu können: Ich hab's schon mal gemacht",
                "den Spitznamen Kevin gehabt (es sei denn mein Name ist Kevin)", "ich habe noch nie im Unterricht geschlafen", "meine Haare gefärbt", "eine Socke verloren", "eine Party mit mehr als 50 Leuten veranstaltet",
                //440
                "erlebt, dass meine oder die Hose eines anderen im Schritt gerissen ist", "einen Ausweis gefälscht", "in einem Aufzug fest gesteckt", "beim Laufen einen Schuh verloren", "meine Webcam abgeklebt",
                "gewünscht, dass ich einen anderen Namen hätte", "mein Handy verloren", "gewünscht, dass ich ein bestimmtes Tier wäre", "in meinem Bett gekotzt", "an einer Demo teilgenommen",
                //450
                "dieses Spiel gespielt und war danach nüchtern", "jemanden/Etwas schön getrunken", "meine Scharmhaare rasiert", "an einer Tür wo 'Drücken' stand gezogen oder wo 'Ziehen' stand gerückt",
                "heimlich die Schränke von einem Freund durchsucht", "einem der Mitspieler an die Brüste gefasst", "jemandem gesagt, dass eine andere Person auf sie steht", "vorgestellt wie es wäre, wenn eine wichtige Person in meinem Leben gestorben wäre",
                "einen Piercing gehabt, ohne dass meine Eltern es wussten", "ein Tatoo gehabt, ohne dass meine Eltern es wussten",
                //460
                "eine hinternfreie Hose getragen", "meine Eltern angelogen hinsichtlich der Tatsache, wo ich hin gehe", "in einem öffentlichen Theaterstück mitgespielt", "etwas von der Schule/Arbeit geklaut",
                "bei einem Chinesen gegessen", "unter Vollnarkose gestanden", "in einer Flugzeugtoilette uriniert, wärend Turbulenzen", "ein Valentinstagsgeschenk bekommen", "jemandem etwas zum Valentinstag geschenkt",
                "mich selbstbefriedigt",
                //470
                "eine andere Sprache außer meiner Muttersprache fließend gesprochen", "illegal Filme oder Spiele heruntergeladen", "mit offenen Augen geküsst", "in der Öffentlichkeit gekotzt", "etwas in einem öffentlichen Verkehrsmittel vergessen",
                "die Eier eines Mannes gekrault", "mit Eiern jongliert", "uneingeladen zu einer Party gekommen", "eine Opernvorstellung besucht", "Hausarrest gehabt",
                //480
                "auf einem Behindertenklo gesessen", "aus Frust Alkohol getrunken", "eine Beziehung vor meinen Eltern geheim gehalten", "einen fremden Penis in der Hand", "die Schultoilette benutzt", "erlebt, dass meine Eltern mich betrunken gesehen haben",
                "meine Haare geglättet", "ein Aufklärungsgespräch mit meinen Eltern gemacht", "mit jemandem geflirtet um etwas billiger/kostenlos zu bekommen", "einen Call-Service angerufen",
                //490
                "ein Doggy Bag mit nach Hause genommen", "erlebt, dass jemand min einem Auto über meinen Fuß gefahren ist", "auf einem Pferrd gesessen", "Pferd gegessen", "bei diesem Spiel etwas herausgefunden, dass ich lieber nicht gewusst hätte",
                "das Synonym 'Geleepistole'(Penis) gehört", "das Synonym 'Sargbewohner'(Vampir) gehört", "den Film Ananas Express geguckt", "Alarm im Darm geguckt", "eine Leiche gesehen",
                //500
                "drinnen in einem Zelt übernachtet", "ein Kondom aufgeblasen", "Wasserbomben geworfen", "einen Flug im Helikopter gemacht", "ein Kaugummi unter einen Tisch/Stuhl oder unter eine Bank geklebt",
                "One Direction gemocht", "Justin Bieber gemacht", "ein Dixieklo benutzt", "'Ich liebe dich' gesagt, ohne dass ich es so meinte", "einen Joint geraucht",
                //510
                "ein Tier an- oder überfahren", "ein Instrument gespielt", "ein Konzert besucht", "ein Techno-/Elektrofestival besucht", "eine Bpng geraucht", "mein Essen ge-instagramt", "einen Bienenstich bekommen",
                "einen Film im Kino geguckt, ohne dafür zu bezahlen", "Dosenstechen gemacht", "ein Kamel geritten",
                //520
                "einen Arzttermin vergessen", "einen Auftritt im Fernsehen gehabt", "einer Sekte angehört", "einen Piercing gebabt", "eine Bowlingkugel für etwas anderes als Bowling benutzt", "ein Bett kaputt gemacht",
                "einen Blog gehabt", "ich habe noch nie eine Raubkopie gekauft", "auf anhieb das ganze Alphabet rückwärts aufgesagt", "einen Termin verpasst oder bin zu spät gekommen, weil ich auf eine Uhr geguckt habe die falsch eingestellt war",
                //530
                "bis 1000 gezählt", "erlebt, dass jemand mich angepinkelt hat", "gewünscht, dass ich eine größere Blase hätte", "irgendwo mit einem Rap bestellt", "einen Kuss im Regen bekommen",
                "einen meiner Knochen gebrochen", "einen Men in Black Film gesehen", "einen Song vorgesungen bekommen", "den Körper gehabt, den ich immer haben wollte", "in Jogginghose das Haus verlassen und bin mit ihr in der Öffentlichkeit rum gelaufen",
                //540
                "Sushi gegessen", "ein Bad in einem öffentlichem Schwimmbad nachts genommen", "einen Schwimmgang in einem Ocean gemacht", "etwas peinliches gemacht, sodass die ganze Klasse über mich gelacht hat",
                "ausgesehen wie eine Prinzessin", "eine echte Prinzessin persönlich getroffen", "jemanden ernsthaft ignoriert", "erlebt, dass mich jemand ernsthaft ignoriert hat", "auf einem Ball getantzt", "einen Walzer getantzt",
                //550
                "mein Haar gefönt", "eine Bromance gehabt", "Scarface gesehen", "jemanden ums Eck' gehabt", "bei einem Spiel geschummelt", "bei einem Videospiel gecheatet", "ein Buch angefangen, aber nie beendet",
                "ein Buch komplett gelesen", "einen Urlaub nur mit Freunden gemacht", "einen Stender in der Öffentlichkeit bekommen",
                //560
                "an Blumen gerochen", "Blumen gepflückt", "ein Picknick auf einer Wiese gemacht", "einen Herr der Ringe Film gesehen", "einen Laptop gehabt", "einen PC gehabt", "einen PC selber zusammen gebaut",
                "ein Getränk aus einer Dose getrunken", "den Browser Internet Explorer benutzt", "Minecraft gespielt",
                //570
                "Fassbrause getrunken", "ein alkoholisches Getränk getrunken", "ein IPhone besessen", "ein Mac besessen", "ein Tablet besessen", "eine Sexpuppe besessen", "einen Vibrator besessen", "meine Telefonnummer vergessen",
                "von Freunden erzählt bekommen, dass kurz nachdem ich gegangen bin etwas richtig cooles passiert ist", "Wahrheit oder Pflicht gespielt",
                //580
                "jemanden richtig doll gehasst", "eine Leggins getragen", "Strumpfhosen getragen", "Bilder von mir als Baby gesehen", "Wrestlemania geguckt", "jemanden wiederbelebt", "an Klebe geschnüffelt", "an einem Edding geschnüffelt",
                "bei einem Marathon mitgemacht", "bei einem Triathlon mitgemacht",
                //590
                "überprüft, ob alle Buchstaben auf der Tastatur an der richtigen Stelle ist", "zu einem Taxifahrer gesagt: 'Ich möchte gerne nach Hause'", "einen Feind zum Freund gemacht", "einen Pixelfehler gesehen",
                "eine Sonnenfinsternis beobachtet", "ohne Schutzbrille in die Sonne geguckt", "bei Regen Fußball gespielt", "die Buchstaben einer Tastatur vertauscht", "so getan als wäre ich blind",
                "ein U-Boot besichtigt",
                //600
                "in einem Orchester mitgespielt", "ein Hospiz besucht", "einen Umzug gemacht", "bei einem Umzug geholfen", "in einem eigenen Haus gewohnt", "eine Tablette schlucken wollen und mich dann an ihr verschluckt",
                "einen Teller auf einem Stab gedreht", "eine Flasche auf meiner Nase balanciert", "etwas auf ex getrunken", "etwas durch meine Nase getrunken",
                //610
                "etwas mit einer elektrischen Fliegenklatsche getötet", "jemandem oder mich mit einer elektrischen Fliegenklatsche geschockt", "einen Defibrillator verwendet", "einen Salto gemacht", "einen Sprung auf einem Trampolin gemacht",
                "eine Getränkedose mit der Hand zerquetscht", "einen Kaktus gegossen", "dieses Spiel gespielt", "für eine App bezahlt", "eine Fledermaus gegessen",
                //620
                "außerhalb der Schule an einem Matheunterricht teilgenommen(Nachhilfe zählt auch)", "essen anbrennen lassen", "meine Haut an etwas verbrannt", "ein Lied komponiert", "die Unterhose mit einer anderen Person getauscht",
                "etwas von Ikea gekauft", "einen Biss von einer Katze bekommen", "einen Biss von einem Hund bekommen", "eine Spinne gegessen", "einen Spinnenbiss bekommen",
                //630
                "versucht etwas kostenloses zu klauen", "neben das Klo gepinkelt", "ein ganzes Ei auf einmal gegessen", "einen Schnurrbart im Mund gehabt", "einen Afro gehabt oder eine Afroperücke getragen",
                "meinem Lehrer oder meinem Chef auf den Arsch gestarrt", "mit mir selbst geredet", "meine Eltern beim Sex erwischt", "eine Hauswand angepinkelt", "einen Sprung gegen die Wand gemacht",
                //640
                "einen elektrischen Zaun angefasst", "gegen einen elektrischen Zaun gepinkelt", "auf der Motorhaube eines fahrenden Autos gesessen", "gemerkt wie sich das Poloch ausstülpt, wenn man schwere Sachen hebt",
                "einen Pokal gewonnen", "noch nie bei Oma den Teller nicht leer gegessen", "eine Strafe gezahlt, weil ich zu schnell gefahren bin", "einen Kunden angelogen um meine Ruhe zu haben", "ein Tastenhandy besessen",
                "darüber gelogen, was ich arbeite",
                //650
                "nach einer Party nicht mehr nach Hause gefunden", "eine Person die ich online kennen gelernt habe in wirklichkeit getroffen", "während des Unterrichts etwas an meinem Handy gemacht",
                "Steine gegessen", "einen Fetish gehabt", "Hasch-Brownies gegessen", "ein Trinkspiel gespielt(außer diesem)", "Öffentlich uriniert", "Für einen Freund mit jemandem geflirtet", "jemandem auf Ebay abgezogen",
                //660
                "eine Penispumpe benutzt", "mit einer Frau/einem Mann geschlafen, die/der eine Silikonhüfte hatte", "mit Socken geduscht", "Liebeskummer gehabt", "eine Brille ohne Gläser getragen", "jemanden mit Absicht abgefüllt",
                "mich selber angepinkelt", "passiv Sex gehabt", "eine ganze Spaghetti gegessen, ohne sie zu zerkauen", "einen BH getragen",
                //670
                "etwas auf Youporn hochgeladen", "jemanden aus sexuellen Gründen geschlagen", "im stehen gepinkelt", "den Spitznamen Peanut gehabt", "Freunden abgesagt um zu Hause alleine zu chillen", "gefastet",
                "Sex auf einem Dixieklo gehabt", "so ein \"Fuck Yeah!\" Gefühl gehabt", "zwischen 24:00 Uhr und 6:00 in einem Restaurant gegessen", "beim Sex ein Bett kaputt gemacht",
                //680
                "etwas in meiner Unterhose versteckt", "an einer Achsel geleckt", "an einem Hintern geleckt", "einen Filmriss gehabt", "einen luziden Traum gehabt", "aus Frust geshoppt", "aus Frust gegessen",
                "Freihändig onaniert", "einen Orgasmus vorgetäuscht", "einen Schweißgeruch anziehend gefunden",
                //690
                "mit jemandem geflirtet, weil ich wusste dass die Person reich ist", "unter der Dusche Zähne geputzt", "in diesem Spiel gelogen", "eine Massenerektion verursacht", "bei den Suchergebnissen von Google die zweite Seite angeguckt",
                "versucht etwas, dass jemandem anderem gehört zu verkaufen", "mich im Mund verbrannt", "eine Autogrammstunde gegeben", "eine Autogrammstunde besucht", "bei einer öffentlichen Vorstellung den Sitzplatz gewechselt, um neben einer anderen Person zu Sitzen",
                //700
                "in einen Brunnen gepinkelt", "einen Bauchklatscher gemacht", "Sushi selber gemacht", "online iin einem Forum einen Thread geöffnet, um eines meiner Probleme zu lösen", "jemanden gesehen der so langsam getippt hat, dass es schon weh tat",
                "auf eine Pizza eine ungewöhnliche Zutat getan", "einen Schwanzvergleich gemacht", "einen Affen auf dem Arm gehabt", "eine Mund zu Mund Beatmung bei einem Menschen gemacht", "eine Mund zu Mund Beatmung bei einem Tier gemacht",
                //710
                "überlegt oder ausgerechnet, mit welcher alltäglichen Beschäftigung ich wie viele Kalorien verbrenne", "bei einem Buch Seiten ausgerissen", "eins meiner Schulbücher verbrannt", "einen Strauß geritten",
                "mein Haustier gebadet", "mit meinem Haustier gebadet", "meinem Haustier die Haare geschnitten","mein Bett kaputt gemacht", "das Bett eines Anderen kaputt gemacht"
        };
        int i = 0;
        while (i < aufgaben.length){
            Fragen.add(aufgaben[i]);
            i++;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_game) {
            startActivity(new Intent(getApplicationContext(), QuestionAdd.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
            TextView aufgaben_tw = (TextView) findViewById(R.id.aufgaben_tw2);

            if (Fragen.size() == 0){
                addQuestions();
                Toast.makeText(getApplicationContext(), getString(R.string.allQuestions), Toast.LENGTH_LONG).show();
            }
            int random = (int) (Math.random() * Fragen.size());
            String item = Fragen.get(random);
            aufgaben_tw.setText("Ich habe noch nie " + item);
            Fragen.remove(item);
    }

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), LayoutMainActivity.class));
        this.finish();
    }
}
