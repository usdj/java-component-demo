package com.usdj.pattern.adapter;

/**
 * @author gerrydeng
 * @date 2019-07-24 15:13
 * @Description:
 */
public class NoteBook {

    private ThreePlugIf plugIf;

    public NoteBook(ThreePlugIf plugIf) {
        this.plugIf = plugIf;
    }


    public void charge(){
        plugIf.powerWithThree();
    }

    public static void main(String[] args) {
        GBTwoPlug gbTwoPlug = new GBTwoPlug();
        ThreePlugIf threePlugIf = new TwoPlugAdapter(gbTwoPlug);
        NoteBook noteBook = new NoteBook(threePlugIf);
        noteBook.charge();
        threePlugIf = new TwoPlugAdapterExtends();
        noteBook = new NoteBook(threePlugIf);
        noteBook.charge();
    }
}
