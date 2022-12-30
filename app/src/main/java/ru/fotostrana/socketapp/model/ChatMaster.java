package ru.fotostrana.socketapp.model;

/* loaded from: classes2.dex */
public class ChatMaster {
    private String answer1;
    private String answer2;
    private int option1NextQuestionArrayIndex;
    private int option2NextQuestionArrayIndex;
    private String question1;
    private String question2;
    private int selfMessage;

    public ChatMaster(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        this.question1 = str;
        this.question2 = str2;
        this.answer1 = str3;
        this.answer2 = str4;
        this.selfMessage = i;
        this.option1NextQuestionArrayIndex = i2;
        this.option2NextQuestionArrayIndex = i3;
    }

    public String getQuestion1() {
        return this.question1;
    }

    public String getQuestion2() {
        return this.question2;
    }

    public String getAnswer1() {
        return this.answer1;
    }

    public String getAnswer2() {
        return this.answer2;
    }

    public int getSelfMessage() {
        return this.selfMessage;
    }

    public int getOption1NextQuestionArrayIndex() {
        return this.option1NextQuestionArrayIndex;
    }

    public int getOption2NextQuestionArrayIndex() {
        return this.option2NextQuestionArrayIndex;
    }
}
