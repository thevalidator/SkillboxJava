public class Main {
    public static void main(String[] args) {
        String someText = "Owne-rship - ' ; ; d;; asd: 200 of Site; Agreement to Terms of Use" +
                "These Terms and Conditions of Use (the \"Terms of Use\") apply to the Apple web site" +
                "located at www.apple.com, and all associated sites linked to www.apple.com by Apple," +
                " its subsidiaries and affiliates, including Apple sites around the world" +
                " (collectively, the \"Site\"). The Site is the property of Apple Inc. " +
                "(\"Apple\") and its licensors. BY USING THE SITE, YOU AGREE TO THESE TERMS OF USE; " +
                "IF YOU DO NOT AGREE, DO NOT USE THE SITE. Apple reserves the right, at its sole " +
                "discretion, to change, modify, add or remove portions of these Terms of Use, at " +
                "any time. It is your responsibility to check these Terms of Use periodically for" +
                " changes. Your continued use of the Site following the posting of changes will " +
                "mean that you accept and agree to the changes. As long as you comply with these " +
                "Terms of Use, Apple grants you a personal, non-exclusive, non-transferable, limited" +
                " privilege to enter and use the Site. Content All text, graphics, user interfaces," +
                " visual interfaces, photographs, trademarks, logos, sounds, music, artwork and " +
                "computer code (collectively, \"Content\"), including but not limited to the design," +
                " structure, selection, coordination, expression, \"look and feel\" and arrangement of" +
                " such Content, contained on the Site is owned, controlled or licensed by or to" +
                " Apple, and is protected by trade dress, copyright, patent and trademark laws, " +
                "and various other intellectual property rights;and:unfair,competition,la-ws.";

        String words[] = someText.replaceAll("([^\\w][^-\\w])", " ").split("[\\s.,;:]+");

        for ( int i = 0; i < words.length; i++ ) {
            System.out.println(words[i]);
        }



    }
}
