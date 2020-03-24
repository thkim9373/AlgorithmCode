package programers.etc;

public class SkillTree {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        boolean isPossible = true;
        int skillPosition = 0;
        for (String tree : skill_trees) {

            for (int i = 0; i < tree.length(); i++) {
                char a = tree.charAt(i);
                if (skill.contains(String.valueOf(a))) {
                    char b = skill.charAt(skillPosition);
                    if (a == b) {
                        skillPosition++;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) answer++;
            isPossible = true;
            skillPosition = 0;
        }

//        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
//        //ArrayList<String> skillTrees = new ArrayList<String>();
//        Iterator<String> it = skillTrees.iterator();
//
//        while (it.hasNext()) {
//            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
//                it.remove();
//            }
//        }
//        answer = skillTrees.size();

        return answer;
    }
}
