package org.example.loadtest;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.example.loadtest.APIDetails.*;

public class ToUpperCaseTest {

    private static final JSONObject JSON_PAYLOAD = createTestPayload();

    private static final int NUMBER_REQUESTS = 200;

    private static final ApiRequestTestHelper HELPER = new ApiRequestTestHelper();

    private static final String PATH = "touppercase";

    @Test
    public void uppercaseJs() {
        HELPER.test(JAVASCRIPT_API_ID, NODEJS, NODEJS, PATH, JSON_PAYLOAD, NUMBER_REQUESTS);
    }

    @Test
    public void uppercasePython() {
        HELPER.test(PYTHON_API_ID, PYTHON, PYTHON, PATH, JSON_PAYLOAD, NUMBER_REQUESTS);
    }


    @Test
    public void uppercasePlaneJavaJvm() {
        HELPER.test(PLANE_JAVA_API_ID, PLAIN_JAVA, JVM, PATH, JSON_PAYLOAD, NUMBER_REQUESTS);
    }

    @Test
    public void uppercasePlaneJavaGraalVm() {
        HELPER.test(PLANE_JAVA_API_ID, PLAIN_JAVA, GRAALVM, PATH, JSON_PAYLOAD, NUMBER_REQUESTS);
    }

    @Test
    public void uppercaseQuarkusJvm() {
        HELPER.test(QUARQUS_API_ID, QUARKUS, JVM, PATH, JSON_PAYLOAD, NUMBER_REQUESTS);
    }

    @Test
    public void uppercaseQuarkusGraalVm() {
        HELPER.test(QUARQUS_API_ID, QUARKUS, GRAALVM, PATH, JSON_PAYLOAD, NUMBER_REQUESTS);
    }

    @Test
    public void uppercaseMicronautJvm() {
        HELPER.test(MICRONAUT_API_ID, MICRONAUT, JVM, PATH, JSON_PAYLOAD, NUMBER_REQUESTS);
    }

    @Test
    public void uppercaseMicronautGraalVm() {
        HELPER.test(MICRONAUT_API_ID, MICRONAUT, GRAALVM, PATH, JSON_PAYLOAD, NUMBER_REQUESTS);
    }

    @Test
    public void uppercaseSpringJvm() {
        HELPER.test(SPRING_API_ID, SPRING, JVM, PATH, JSON_PAYLOAD, NUMBER_REQUESTS);
    }

//
//    public void uppercaseSpringGraalVm() {}

    private static JSONObject createTestPayload() {
        final JSONObject payload = new JSONObject();
        payload.put("text1", "fnw6tpjqphd29xfu8xnygtn576nrh58i26m2xp58f4nqvmy9kp6znn23vxd8hmq7v7whc3ipytxutkd2vzj8mjdyhvaw7vuwv6zfwz2yuftmugzccr88r53b67z6jkrkgm8ci3xqqxiyjkqica6gyycd9npkcj65hxu4w7jztpxptzg9nvxqth2iaqbaxqc3dex8m3k8b5ue22j898xb8ih6ht6mdh4idfkg4hhuy74r5r99abuktic2kbv4u8z4xgfqc4n9v776bx8f8ynb8jiqrq4qhapev7hgwvzpveahn5g2jxbmratji6c9xqfebungmyx6pjjmipr2pwkh4uaq7q8zfapquc6aehtgja9ptzqk9rfnba56vxjzep79rukpjwc55bt9eaj9q64z7a9tktedfrkw4d6dvwmki7yzijpa7rhtez4788y5dpn3abqmv2umrdfepdai3pvy3v9ryinq5kenpcgbgfpzxcj37y2y9tu6a4tm379476pz9hmi47kaqezpjun2tfqpuzbpbu9759gwwhmahnfkwx8239jep9wm2cwntvgu6yhawqwzhmprpyc5ehtkihu4igq5nmmuzjc49m89ewqmddiyhu9t9wxy337qnqmtgn6f64drjxgguzeuzf4e7vrgbrg74w6rrcfgm5fiw67kidru983egep32myh323n7urh7bwjc6niv67tfubyk8fawtk47erekudwvaqjwyrw67a985hb7jxq86wqfhkvvm7gvv77kb6xqgm6jynnzp3avpxncgpppwphg2t9chnbmkr4rf9tw6zeu8ckmnzegmuj4cr48nqeryyjzvwxhemigycaq4p64ag5tukugj4mjbcncw98jg7yd7tkqjya462g5ac7z4yepxphbm2mbx33khvt5w82ieu69a3nj4qj5kmcgvkce5xavmevjf3e9y4j33c82y3mg6gynqqzrama5ipfneq7ap5kpwrr7cni");
        payload.put("text2", "696b45yt4nm5g5qpgmaanbvt7mjwxkc4vh4uvk4k8d3njxwpx3jvbv8xqg6ia6awffvhqjxbf4kxnmca4m63hqv3brycmaihfpv39k22vzhmvx2c8hn3d5xbvurvm948ed59aki8482fq3v24agixqkdrheh7ang8e4pvky98u5raxee4j7thu9byj8q639qm5hjv2cpzii34a4tecvcpq49ahg6padf27kqikg4q9nfctib8ftxpn7yd9uji7fnubt54dvamdkpkjgm3uk9btehd3vpztm87u7hgz729dgt6xtr2nq8h3qfvqmrgkwih9ruc4f9b7ku6qydrin9mzyfxm33xd36nynm4w9uyhjvv63c57bdhwp4vem2wwpt9afw922ujn5iajcea6ybajeb3rib4nzftvkaeqb7djt4ifat9pppk97wcb3trwvqib5r4nd5naerimka5rh3qwfw745mkpbi5pn46ty3gif7efgvq2pjtaxt6mcqiyvbfd2rx7jdthzg5mxy8hxt4vk6c9ibdgqpdkmn73h6higa6i48qzuqyqagry4edzuct5e3bfvm83itbxqg4h8e7fvc4kvewtv9yeebkjdbq3ectr4apgvi6aa5cat8fuyaixteguk9qh92my25p5h54g9jwxnzp548rv46dwr677pwycvhc68qkcbv439kt7krat8tb4vecq3yevu4k97zd4k5e9yxpxg6jmvkctcqpyi8b9i2uz4ihqphc2wrbjavqzcfyp88b7idmaimeutd73wddapic3ig44pfzxija9zuvm7zehaiwcarp3m22hpfxqwanxrzntp4v3p5iymx6dfim7htp77etzc2ktuep2p2tae5fhtm7rn9699tfh7cp8gyzc83icwk356gg3jqafqmt3td25ee8z3at9v5quy3c9jm94itfx6zverqdm8vnrabzkiz2uzyy6ye7tacbfx82djfi2b85ec63cy9");
        return payload;
    }

}
