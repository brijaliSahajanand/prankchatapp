package ru.fotostrana.socketapp.constant;

import java.util.ArrayList;

import ru.fotostrana.socketapp.model.ChatMaster;
public class ChatLevels {
    ArrayList<ArrayList> chatMasterArrayList;

    public ArrayList<ArrayList> getChatMasterArrayList() {
        return this.chatMasterArrayList;
    }

    private ArrayList<ChatMaster> level1() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Dad ", "Prank Dad", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("OMG \u1f614", "Hey Dad", "What?", "What?", 1, 2, 2));
        arrayList.add(new ChatMaster("I had an accident ", "I got expelled from school", "What Happened \u1f62e?", "How?", 1, 3, 6));
        arrayList.add(new ChatMaster("I burned my eyebrows\u1f604", "I crashed your car \u1f622", "How \u1f627?", "No you did not", 1, 4, 5));
        arrayList.add(new ChatMaster("During my fireshow", "With flamethrower", "Are you kidding me?", "OMG! What Now!?", 1, 9, 9));
        arrayList.add(new ChatMaster("How do you know?", "Yes I did", "I am sitting in it now \u1f604", "I am sitting in it now \u1f604", 1, 100, 9));
        arrayList.add(new ChatMaster("I escaped from there", "I beat up teacher", "Why?", "Really Why?", 1, 7, 8));
        arrayList.add(new ChatMaster("I hate it there", "I was so bored", "Come home NOW! I am so angry at You!!", "Come home NOW! I am so angry at You!!", 1, 100, 9));
        arrayList.add(new ChatMaster("He was rude", "He gave me F", "Come home NOW! I am so angry at You!!", "Come home NOW! I am so angry at You!!", 1, 100, 9));
        arrayList.add(new ChatMaster("Haha I pranked you \u1f602", "", "", "", 1, 10, 10));
        return arrayList;
    }

    private ArrayList<ChatMaster> level2() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Girlfriend", "Fake Chat", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi baby. What are you doing?", "My baby. Have you eaten?", "I'm working. Have you come home from work?", "I have not eaten anything. Have you finished your job today?", 1, 2, 2));
        arrayList.add(new ChatMaster("I'm on my way home.", "I'm going home soon", "When will you come to me?", "Let me prepare. When will you come to me?", 1, 3, 3));
        arrayList.add(new ChatMaster("About 15 minutes", "About 1 hour", "Call me if you come", "I'm going to wash my hair. When you arrive, call me.", 1, 4, 4));
        arrayList.add(new ChatMaster("Okay honey", "Okay baby", "Waiting !!!", "See you later", 1, 5, 5));
        arrayList.add(new ChatMaster("okay bye bye", "Okay honey", "Bye bye honey", "Okay my baby", 1, 6, 6));
        return arrayList;
    }

    private ArrayList<ChatMaster> level3() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Zoo manager", "get the job", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Are you hiring? \u1f622 ", "I want to work in the zoo\u1f611", "what do you want to do?", "what do you want to do?", 1, 2, 2));
        arrayList.add(new ChatMaster("Feeding lions ", "washing elephants\u1f611", "That's a really dangerous job!\u1f622", "It is  bit risky you know", 1, 3, 3));
        arrayList.add(new ChatMaster("Why?", "Is elephant washing safer?", "The last feeder was eaten \u1f627?", "Elephant stepped on the last guy.", 1, 4, 6));
        arrayList.add(new ChatMaster("Uff.I'll do something else", "I'm not scared\u1f604", "You can wash the elephants", "700$ month.No health insurance", 1, 9, 11));
        arrayList.add(new ChatMaster("Why?", "", "The last feeder was eaten.\u1f604", "", 1, 4, 4));
        arrayList.add(new ChatMaster("I changed my mind... ", "Do I get good salary?", "okay..", "500$ month. No health insurance", 1, 100, 7));
        arrayList.add(new ChatMaster("I need a better offer\u1f620", "Great!!", "Why?", "500$ month.No health insurance", 1, 13, 9));
        arrayList.add(new ChatMaster("I have two lions as house pets", "I have seen lion documentary\u1f611", "1000$+health insurance", "500$ month.No health insurance", 1, 6, 9));
        arrayList.add(new ChatMaster("I changed my mind..", "That's great!\u1f60a", "okay...", "It is bit risky you know", 1, 100, 12));
        arrayList.add(new ChatMaster("It is dangerous\u1f622", "I'm really good with lions", "", "How good?\u1f617", 1, 10, 8));
        arrayList.add(new ChatMaster("I take it!", "I need a better offer ", "Good see you on monday", "Why?", 1, 19, 10));
        arrayList.add(new ChatMaster("Why?\u1f615", "", "Elephant stepped on the last guy.\u1f611", "", 1, 6, 4));
        arrayList.add(new ChatMaster("I'm best elephant washer in town\u1f620", "It is dangerous", "How many elephants you washed?\u1f617", "So what?", 1, 14, 18));
        arrayList.add(new ChatMaster("1000", "100", "1000$+health insurance", "okay..", 1, 15, 19));
        arrayList.add(new ChatMaster("Still not good", "", "I can't give you better offer\u1f612", "", 1, 100, 4));
        arrayList.add(new ChatMaster("Bye!", "ok 1000$ is good enough\u1f611", "OK WAIT. 1500$", "", 1, 4, 4));
        arrayList.add(new ChatMaster("Great \u1f604", "", "Good se you on monday\u1f60e", "", 1, 19, 19));
        arrayList.add(new ChatMaster("I'm not doing it!\u1f604", "ok I take the deal\u1f60a", "ok\u1f60a", "Good see you on monday\u1f60e", 1, 100, 19));
        return arrayList;
    }

    private ArrayList<ChatMaster> level4() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Cute girl", "Ask her out", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hello b ", "Hi girl b", "What do you want?\u1f610", "What do you want?\u1f610", 1, 2, 2));
        arrayList.add(new ChatMaster("Nothing \u1f60d", "Go out with you\u1f60a", "", "Really?\u1f607", 1, 100, 3));
        arrayList.add(new ChatMaster("Yes, you seemed really cool \u1f609", "No lol \u1f602", "You are also kind cute \u1f627?", "son of a biscuit\u1f621", 1, 4, 100));
        arrayList.add(new ChatMaster("Will you marry me? \u1f60d", "Wanna hang out?\u1f60b", "No i barely know you\u1f620", "Yes!\u1f618", 1, 100, 5));
        return arrayList;
    }

    private ArrayList<ChatMaster> level5() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Director AI", "Get the role", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi Director!\u1f60a ", "Hello there\u1f609\t", "Do we know each other?\u1f610", "Do we know each other?\u1f610", 1, 2, 2));
        arrayList.add(new ChatMaster("I want to play in your movie \u1f617\t", "", "And who do you wanna play?", "", 1, 4, 3));
        arrayList.add(new ChatMaster("I want to play in your movie\u1f923", "", "And who do you wanna play?", "son of a biscuit", 1, 4, 10));
        arrayList.add(new ChatMaster("Sheriff", "Bandit", "Okay.But you need to bring your own horse\u1f611", "Can you look scary?\u1f610\t", 1, 5, 6));
        arrayList.add(new ChatMaster("Why?", "I don't have a horse", "We don't have budget for a horse", "Can you look scary?", 1, 7, 7));
        arrayList.add(new ChatMaster("Strange run away from me", "More ugly than scary \u1f622", "Really good see ya!\u1f60e", "That's not really good.\u1f621\t", 1, 12, 10));
        arrayList.add(new ChatMaster("Well I don't have one", "", "Then you can not play sheriff!\u1f611", "", 1, 8, 8));
        arrayList.add(new ChatMaster("Can I be a bandit?", "", "Can you look scary?", "", 1, 9, 9));
        arrayList.add(new ChatMaster("Strange run away from me", "More ugly than scary \u1f622", "Really good see ya!\u1f60e", "That's not really good.", 1, 12, 10));
        arrayList.add(new ChatMaster("Sorry for bothering mister\u1f622", "Can I get another role? \u1f617", "Bye!\u1f621\t", "You can be drunk Jimmy.", 1, 100, 11));
        arrayList.add(new ChatMaster("Sounds great maestro!\u1f622", "I don't want to be drunk Jimmy", "Alright see you on ya see\u1f60e", "Stop bothering me then ...\u1f621\t", 1, 12, 100));
        return arrayList;
    }

    private ArrayList<ChatMaster> level6() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Veterinarians", "Prank Doctor", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi doctor", "Help me! Please", "Can I help you?", "What Happened?", 1, 2, 2));
        arrayList.add(new ChatMaster("My dog is sick", "My cat can't breathe", "How long has it been?", "Very dangerous.How long has it been like this", 1, 3, 3));
        arrayList.add(new ChatMaster("He's like that this afternoon :(", "He's been like that since morning :((", "Okay, now I will give you my address, you bring them to let me check on specific situation", "I'm going to wash my hair. When you arrive, call me.", 1, 4, 4));
        arrayList.add(new ChatMaster("Thank you", "Yes, thank you doctor", "+12345. Call me when you come", "+13456 Call me if you need", 1, 5, 5));
        arrayList.add(new ChatMaster("Thank you sir", "Thanks sir", "Okay", "Okay!", 1, 6, 6));
        return arrayList;
    }

    private ArrayList<ChatMaster> level7() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Felix", "Borrow his car", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi Felix\u1f61b ", "Hello\u1f60e", "Hi, what's up?\u1f610", "Hi, what's up?\u1f610", 1, 2, 2));
        arrayList.add(new ChatMaster("Can I borrow your car?\u1f617 ", "", "why?\u1f619", "", 1, 3, 3));
        arrayList.add(new ChatMaster("Mine is broken\u1f612", "I crashed mine\u1f61f", "Alright...Where do u want to take it?\u1f61f", "Alright...Where do u want to take it?\u1f61f", 1, 4, 4));
        arrayList.add(new ChatMaster("Paraguay", "Just to NY and back", "ARE YOU CRAZY?!\u1f626", "OK.You have driving license,right?\u1f615", 1, 5, 7));
        arrayList.add(new ChatMaster("Just kidding\u1f61c", "I want to go on a road trip\u1f61b", "Oh.I was legit scared\u1f617", "I won't borrow you my car!\u1f621", 1, 6, 100));
        arrayList.add(new ChatMaster("Would you borrow me the car?\u1f617", "", "OK.You have driving license,right?\u1f615", "", 1, 7, 5));
        arrayList.add(new ChatMaster("Of course", "No license at all ", "ok, but please don't scratch it\u1f61f", "I won't borrow you my car!\u1f621", 1, 8, 100));
        return arrayList;
    }

    private ArrayList<ChatMaster> level8() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Jake", "Ask him to prom", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Would you be my prom date?\u1f628 ", "Let's go out side", "ldk\u1f603", "Afcorse baby", 1, 2, 2));
        arrayList.add(new ChatMaster("Why? ", "U have someone else?", "I can't dance\u1f61b", "No\u1f61f", 1, 3, 6));
        arrayList.add(new ChatMaster("Me neither\u1f61b ", "I will teach you", "I also can't choose a suit", "I also can't choose a suit ", 1, 4, 4));
        arrayList.add(new ChatMaster("Navy blue", "Charcoal black", "That should work!\u1f610", "That should work!\u1f610", 1, 5, 5));
        arrayList.add(new ChatMaster("So, are you coming with me?\u1f628", "shell we go ?", "Okay, I will be your prom date\u1f60a ", "", 1, 7, 7));
        arrayList.add(new ChatMaster("What's the problem then?\u1f636", "Please come with me\u1f64f", "I can't dance\u1f62d", "ok", 1, 3, 7));
        return arrayList;
    }

    private ArrayList<ChatMaster> level9() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Rocker Andy\u1f608", "Get the band", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi Andy! ", "Whatsuuup\u1f61b", "Whatsuuup dude", "Whatsuuup dude", 1, 2, 2));
        arrayList.add(new ChatMaster("I want to be singer in your band\u1f60e ", "", "Are you a good singer?\u1f61b", "", 1, 3, 3));
        arrayList.add(new ChatMaster("Yes\u1f60e ", "No\u1f637", "Good, can you rhyme like a God\u1f60e", "Then why are you writing me man?\u1f61b", 1, 4, 6));
        arrayList.add(new ChatMaster("Hell yeah!\u1f608", "Kinda", "I will test ya\u1f608", "I will test ya\u1f608", 1, 5, 5));
        arrayList.add(new ChatMaster("Let's get them RHYMES\u1f608", "Test your mom not Me!\u1f61c", "What rhymes with  DUCK? ", "You are kinda rude. I don't want like that\t\u1f61f", 1, 7, 8));
        arrayList.add(new ChatMaster("I can rhyme pretty good \u1f608", "dunno", "I will test ya\u1f62d", "Stop bothering me BRO\u1f61c", 1, 5, 100));
        arrayList.add(new ChatMaster("Truck ", "Jump", "DAMN! You are the new singer boiii\u1f62d", "Stop bothering me BRO\t\u1f61f", 1, 8, 100));
        return arrayList;
    }

    private ArrayList<ChatMaster> level10() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("MoM", "Fake Chat", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi mom", "Oh mom?", "Where are you?", "Where are you now?", 1, 2, 2));
        arrayList.add(new ChatMaster("In school", "Party", "I know you lie =.=. Who's next to you?", "Who's there with you?", 1, 3, 3));
        arrayList.add(new ChatMaster("Sorry mom. My girl friend", "You don't believe me? Really! I am with my classmates", "Really, Come home let's talk with your dad about your GF", "I asked again, where are you?", 1, 100, 4));
        arrayList.add(new ChatMaster("At friends house", "At Bar", "I think you should come back home before 10.00 pm tonight", "I am going to kill you tonight come home", 1, 5, 100));
        arrayList.add(new ChatMaster("Okay mom", "Yes sir", "Okay, my baby", "Okay!", 1, 6, 6));
        return arrayList;
    }

    private ArrayList<ChatMaster> level11() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Kardi G", "Get free tickets", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi Kardi!!!\u1f603", "Hello. \u1f607", "What do you need sweetheart?\u1f60a", "What do you need sweetheart?\u1f60a", 1, 2, 2));
        arrayList.add(new ChatMaster("Free tickets for your show  \u1f61d", "", "Why should I give you free tickets?\u1f611", "", 1, 3, 3));
        arrayList.add(new ChatMaster("I'm your biggest fan", "Your music changed my life", "Prove it?", "How?", 1, 4, 6));
        arrayList.add(new ChatMaster("How ?\u1f615", "Ok\u1f60a", "What's the name of my first song?", "I don't remember anything..\u1f614", 1, 5, 100));
        arrayList.add(new ChatMaster("Love Yourself", "Call Dem Copz", "Correct! How many tickets do u want? ", "No, it was Love yourself \u1f62d", 1, 8, 100));
        arrayList.add(new ChatMaster("I learned how to love myself\u1f60b ", "I dropped out of school like you", "Awww.That's cute \u1f62d. How many tickets do you want?", "That's not good girl\u1f617", 8, 7, 1));
        arrayList.add(new ChatMaster("Will I get the tickets?\u1f612", "I know\u1f623", "I've never told anyone to leave school", "I've never told anyone to leave school\u1f620", 1, 100, 100));
        arrayList.add(new ChatMaster("2", "10", "You get them! \u1f60a", "You get them! \u1f60a", 1, 9, 9));
        return arrayList;
    }

    private ArrayList<ChatMaster> level12() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Lost friend", "Find him", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Where are you?", "can you know place ? where you seated", "I don't know\u1f626\t", "", 1, 2, 2));
        arrayList.add(new ChatMaster("How can you not know? ", "", "I don't remember anything..\u1f626\t", "", 1, 3, 3));
        arrayList.add(new ChatMaster("Are you inside? ", "Are you outside?", "I'm on some street...", "I'm on some street...", 1, 4, 4));
        arrayList.add(new ChatMaster("What street?", "Where?", "I can't read the street name", "I don't remember anything..\t\u1f615", 1, 5, 5));
        arrayList.add(new ChatMaster("You forgot to read?", "Why?", "The letters are really weird... \t\u1f615", "The letters are really weird...\t\u1f615", 1, 6, 6));
        arrayList.add(new ChatMaster("Where are you?", "Weird how?", " I don't remember anything..\u1f62d", "I think I'm in Russia\t\u1f615", 1, 7, 7));
        arrayList.add(new ChatMaster("Is it cold there?", "What time is there?", "Yeah pretty cold", "6:45 pm", 1, 8, 8));
        arrayList.add(new ChatMaster("You are not in Russia", "That must be Russia", "Where am i?\u1f612", "I don't remember anything..\u1f612", 1, 9, 100));
        arrayList.add(new ChatMaster("China", "Wisconsin", "You are not in China", "Can you pick me up?", 1, 100, 10));
        arrayList.add(new ChatMaster("I'm busy today", "I'm on my way", "Okay, I will come back my self\u1f60a", "Okay, I will come back my self\u1f60a", 1, 100, 11));
        return arrayList;
    }

    private ArrayList<ChatMaster> level13() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Bar manager", "Get the refund", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Are you the manager of Sly Pint Bar?", "", "Yes that's me! How can i help you?\u1f642", "", 1, 2, 2));
        arrayList.add(new ChatMaster("Yesterday i got injured in your bar\u1f626 ", "", "I'm so sorry what happend?\u1f62e", "", 1, 3, 3));
        arrayList.add(new ChatMaster("Waiter spilled flaming drink on me ", "Somebody threw chair at me", "Are you hurt?", "Are you hurt?\u1f62e", 1, 4, 11));
        arrayList.add(new ChatMaster("I have psychlogical trauma\u1f626", "My leg is burnt\u1f62e", "I'm sorry but we can't give you a refund", "I'm sorry but we can't give you a refund", 1, 5, 5));
        arrayList.add(new ChatMaster("Why?\u1f626", "I will sue you!\u1f621", "You have no evidence ", "My leg is burnt", 1, 6, 10));
        arrayList.add(new ChatMaster("My friends saw that ", "Go to hell\u1f621", "Okay we will give you 100$ credit in our bar\u1f60a", "You to mister...\u1f621", 1, 7, 100));
        arrayList.add(new ChatMaster("Great! Thanks\u1f603", "That's not enough", "Stop bothering me BRO", "What else do you want?", 1, 100, 8));
        arrayList.add(new ChatMaster("Justice!", "1000$ cash!", "What does that mean?", "What else do you want?", 1, 9, 100));
        arrayList.add(new ChatMaster("1000$", "Fire the waiter who was serving me\u1f611", "We won't give that. I'm sorry", "What else do you want?", 1, 10, 100));
        arrayList.add(new ChatMaster("Go to hell!\u1f621", "I'll call my lawyer\u1f621", "You to mister...\u1f621", "Alright. Calm down 1000$ is fine", 1, 100, 12));
        arrayList.add(new ChatMaster("Not at all ", "I'm hurt very bad!\u1f623", "", "Okay we will give you 100$ credit in our bar \u1f62d", 1, 8, 12));
        return arrayList;
    }

    private ArrayList<ChatMaster> level14() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Ghost", "Prank the ghost", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hello", "Hi", "BoooooHoooo", "BoooooHooo", 1, 2, 2));
        arrayList.add(new ChatMaster("Who are you?", "Are you a real ghost?", "Ahahahah", "Ahahahah", 1, 3, 3));
        arrayList.add(new ChatMaster("What do you want?", "Why are you bothering me?", "Want to scare you!", "Want to scare you!", 1, 4, 4));
        arrayList.add(new ChatMaster("Where are you?", "Why?", "Under your bed!", "Because I am bored!", 1, 5, 6));
        arrayList.add(new ChatMaster("Really!", "I am scared", "Yes", "Huhuhuhuh!", 1, 100, 100));
        arrayList.add(new ChatMaster("Try theater or movies!", "Read books!", "Good idea, Bye!", "Good idea, Bye", 1, 7, 7));
        return arrayList;
    }

    private ArrayList<ChatMaster> level15() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("President", "Be a President!", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi", "Hello", "Who's there?", "Who are you?", 1, 2, 2));
        arrayList.add(new ChatMaster("I am President!", "Owner of White House", "Really?", "Really?", 1, 3, 3));
        arrayList.add(new ChatMaster("YES!", "Of-course!", "What do you want?", "What do you want?", 1, 4, 4));
        arrayList.add(new ChatMaster("Meetup!", "Catch me up in White House!", "For what?", "For what?", 1, 5, 5));
        arrayList.add(new ChatMaster("I have a BBQ party!", "Because I am the President!", "I can't come!", "I am not available!", 1, 6, 6));
        arrayList.add(new ChatMaster("I order you!", "Please", "Ok!", "Heheheh!", 1, 7, 100));
        return arrayList;
    }

    private ArrayList<ChatMaster> level16() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Jerry", "Prank Jerry", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi Jerry!", "Hello Jerry!", "Hello", "Hello", 1, 2, 2));
        arrayList.add(new ChatMaster("Let's do something crazy!", "Outing?", "Like what?", "What?", 1, 3, 3));
        arrayList.add(new ChatMaster("Adventure?", "Road-trip?", "Adventure!", "Road-trip!", 1, 4, 4));
        arrayList.add(new ChatMaster("Canada?", "Slovakia", "Good! But I don't have a car", "Good! But I don't have a car", 1, 5, 5));
        arrayList.add(new ChatMaster("We can hitchhike!", "I will take from my dad!", "Good that is an adventure!", "Will he allow?", 1, 100, 6));
        arrayList.add(new ChatMaster("I won't tell him!", "I guess!", "Good! let's go", "Good! let's go!", 1, 7, 7));
        return arrayList;
    }

    private ArrayList<ChatMaster> level17() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Super Hero Spider", "Prank Spider", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi", "Hello", "Hi", "Hello", 1, 2, 2));
        arrayList.add(new ChatMaster("Who is there?", "Who are you?", "I am superhero spider!", "I am superman!", 1, 3, 3));
        arrayList.add(new ChatMaster("Ohhhh! Really?", "What do you want from me?", "I want to go on a date with you!", "Wanna date with you!", 1, 4, 4));
        arrayList.add(new ChatMaster("Awww! Really?", "Are you kidding me?", "Yess!", "No, I am serious!", 1, 5, 5));
        arrayList.add(new ChatMaster("Why me?", "Why?", "Because I like you!", "I like you surely!", 1, 6, 6));
        arrayList.add(new ChatMaster("Awwww, tomorrow 9PM!", "Tell me location?", "Great!", "White house, 123!", 1, 100, 7));
        arrayList.add(new ChatMaster("You making me fool?", "You idiot!", "Hahahaha!", "Hahahaha!", 1, 8, 8));
        return arrayList;
    }

    private ArrayList<ChatMaster> level18() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Zombie", "Prank Zombie", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi!", "Hello!", "Hello!", "Hi!", 1, 2, 2));
        arrayList.add(new ChatMaster("Who are you?", "???", "I am zombie!", "Zombie here!", 1, 3, 3));
        arrayList.add(new ChatMaster("Really?", "I don't believe you!", "I am zombie from World War Z!", "Do believe it!", 1, 4, 4));
        arrayList.add(new ChatMaster("So, what?", "What do you want from me?", "I want to invite you to my house!", "I want to invite you to my house!", 1, 5, 5));
        arrayList.add(new ChatMaster("What?", "For what?", "I want to eat you!", "I want to eat you!", 1, 6, 6));
        arrayList.add(new ChatMaster("Ohhh! please don't message me!", "Sure, tell me address!", "Hahahaha! poor you scared!", "Street 3 London!", 1, 100, 7));
        arrayList.add(new ChatMaster("Sure, Sure", "I am not vaccinated!", "Come on!", "Ohhhhh, poor me!", 1, 8, 8));
        return arrayList;
    }

    private ArrayList<ChatMaster> level19() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("911", "Save Yourself", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi!", "Hello!", "Hi, you are under arrest!", "Hello, you are under arrest!", 1, 2, 2));
        arrayList.add(new ChatMaster("What?", "Why?", "I am not going to comment on this!", "I am not answerable to you!", 1, 3, 3));
        arrayList.add(new ChatMaster("I am confused!", "You can't just arrest me!", "You are going to jail!", "We will, and will send you to jail!", 1, 4, 4));
        arrayList.add(new ChatMaster("For what?", "I ain't going anywhere!", "Confess and you will be free!", "Confess and you will get nice cell!", 1, 5, 5));
        arrayList.add(new ChatMaster("I was just jail walking!", "But I didn't do anything!", "I knew, now get ready!", "Are you sure? We have proves!", 1, 100, 6));
        arrayList.add(new ChatMaster("Yes!", "Absolutely sure", "Ok, we were just checking you!", "Ok, we were just checking you!", 1, 7, 7));
        return arrayList;
    }

    private ArrayList<ChatMaster> level20() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Vampire", "Resist Vampire", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi!", "Hello!", "I would love to invite you to my castle!", "I would love to invite you to my castle!", 1, 2, 2));
        arrayList.add(new ChatMaster("Great idea!", "Sorry, I am not interested!", "I am waiting for you!", "We will drink tomato juice and watch old movies!", 1, 100, 3));
        arrayList.add(new ChatMaster("I am not coming!", "I don't like tomato juice!", "Come and I will grant you one wish!", "Ok, what about cucumber juice?", 1, 4, 4));
        arrayList.add(new ChatMaster("Still not interested!", "Ok, no reason to talk more!", "You are rude!", "Hey wait!", 1, 5, 5));
        return arrayList;
    }

    private ArrayList<ChatMaster> level21() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Circus Owner", "Don't be a clown", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi!", "I missed a call from you?", "We need your help!", "We need your help!", 1, 2, 2));
        arrayList.add(new ChatMaster("Me?", "Why?", "Our clown is sick!", "Our clown is missing!", 1, 3, 3));
        arrayList.add(new ChatMaster("What should I do?", "So, how can I help you?", "We heard you are a funny person!", "We want you as his replacement!", 1, 4, 4));
        arrayList.add(new ChatMaster("You want me to be a clown?", "What did you just said?", "Yes!", "Be a clown!", 1, 5, 5));
        arrayList.add(new ChatMaster("I am not that funny", "No, I can't!", "Alright, are you good at gymnastics?", "Ok, as your wish!", 1, 6, 100));
        arrayList.add(new ChatMaster("Yes!", "Why?", "Be our stunt man!", "Our main stunt man is also ill!", 1, 7, 7));
        arrayList.add(new ChatMaster("Ok, I can be that!", "I can do some stunts!", "That's great!", "That's great!", 1, 8, 8));
        return arrayList;
    }

    private ArrayList<ChatMaster> level22() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Thug", "Save your money", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hello", "Hi!", "Where is the money Leo?", "Where is the money Leo?", 1, 2, 2));
        arrayList.add(new ChatMaster("What?", "Which money?", "Where is the money?", "Our money!", 1, 3, 3));
        arrayList.add(new ChatMaster("I don't know you!", "I don't know anything!", "Don't play with us!", "Don't play with us!", 1, 4, 4));
        arrayList.add(new ChatMaster("What are you talking about?", "I didn't get you!", "Your wife owes our boss money!", "Your wife owes our boss money!", 1, 5, 5));
        arrayList.add(new ChatMaster("I don't have a wife!", "You have got the wrong guy!", "Are you Loe?", "Ain't you Leo?", 1, 6, 6));
        arrayList.add(new ChatMaster("No", "Yes", "Ohhh sorry! we made a mistake!", "Now wait and watch!", 1, 7, 100));
        return arrayList;
    }

    private ArrayList<ChatMaster> level23() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Wild Lion", "Feed the lion", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi!", "Hello!", "Hi! I need your help!", "Hi! I need your help!", 1, 2, 2));
        arrayList.add(new ChatMaster("How can I help?", "What should I do?", "I am hungry, bring me meet!", "I am hungry, bring me meet!", 1, 3, 3));
        arrayList.add(new ChatMaster("Where?", "Why?", "I am in the zoo!", "Cause I am really hungry!", 1, 4, 4));
        arrayList.add(new ChatMaster("I don't want to help you!", "In what zoo?", "Bring me meet or I will escape from zoo!", "In the central park!", 1, 5, 6));
        arrayList.add(new ChatMaster("I won't bring you meet!", "Okay!", "I will escape and eat you!", "Great, come quick!", 1, 100, 7));
        arrayList.add(new ChatMaster("Sorry, that is too far!", "Okay, Bringing!", "I will escape and eat you!", "Great, come quick!", 1, 100, 7));
        return arrayList;
    }
    private ArrayList<ChatMaster> level24() {
        ArrayList<ChatMaster> arrayList = new ArrayList<>();
        arrayList.add(new ChatMaster("Kardi G", "Get free tickets", "", "", 1, 1, 1));
        arrayList.add(new ChatMaster("Hi Kardi!!!\u1f603", "Hello. \u1f607", "What do you need sweetheart?\u1f60a", "What do you need sweetheart?\u1f60a", 1, 2, 2));
        arrayList.add(new ChatMaster("Free tickets for your show  \u1f61d", "", "Why should I give you free tickets?\u1f611", "", 1, 3, 3));
        arrayList.add(new ChatMaster("I'm your biggest fan", "Your music changed my life", "Prove it?", "How?", 1, 4, 6));
        arrayList.add(new ChatMaster("How ?\u1f615", "Ok\u1f60a", "What's the name of my first song?", "I don't remember anything..\u1f614", 1, 5, 100));
        arrayList.add(new ChatMaster("Love Yourself", "Call Dem Copz", "Correct! How many tickets do u want? ", "No, it was Love yourself \u1f62d", 1, 8, 100));
        arrayList.add(new ChatMaster("I learned how to love myself\u1f60b ", "I dropped out of school like you", "Awww.That's cute \u1f62d. How many tickets do you want?", "That's not good girl\u1f617", 8, 7, 1));
        arrayList.add(new ChatMaster("Will I get the tickets?\u1f612", "I know\u1f623", "I've never told anyone to leave school", "I've never told anyone to leave school\u1f620", 1, 100, 100));
        arrayList.add(new ChatMaster("2", "10", "You get them! \u1f60a", "You get them! \u1f60a", 1, 9, 9));
        return arrayList;
    }



    public ChatLevels() {
        this.chatMasterArrayList = new ArrayList<>();
        this.chatMasterArrayList.add(level1());
        this.chatMasterArrayList.add(level2());
        this.chatMasterArrayList.add(level3());
        this.chatMasterArrayList.add(level4());
        this.chatMasterArrayList.add(level5());
        this.chatMasterArrayList.add(level6());
        this.chatMasterArrayList.add(level7());
        this.chatMasterArrayList.add(level8());
        this.chatMasterArrayList.add(level9());
        this.chatMasterArrayList.add(level10());
        this.chatMasterArrayList.add(level11());
        this.chatMasterArrayList.add(level12());
        this.chatMasterArrayList.add(level13());
        this.chatMasterArrayList.add(level14());
        this.chatMasterArrayList.add(level15());
        this.chatMasterArrayList.add(level16());
        this.chatMasterArrayList.add(level17());
        this.chatMasterArrayList.add(level18());
        this.chatMasterArrayList.add(level19());
        this.chatMasterArrayList.add(level20());
        this.chatMasterArrayList.add(level21());
        this.chatMasterArrayList.add(level22());
        this.chatMasterArrayList.add(level23());
        this.chatMasterArrayList.add(level24());
    }
}
