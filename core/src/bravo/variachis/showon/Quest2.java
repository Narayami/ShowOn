package bravo.variachis.showon;

public class Quest2 {

    private int questCount = 0;
    private boolean resolvedQuest = false;

    public int getQuestCount() {
        return questCount;
    }

    public void setQuestCount(int questCount) {
        this.questCount = questCount;
    }

    public boolean checkQuest(){
        if(resolvedQuest == true){
            System.out.println("quest resolved");
            return true;
        }
        System.out.println("quest not resolved");
        return false;

    }
}
