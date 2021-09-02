import * as web3 from '@solana/web3.js';


class SendCertificate {
  async sendCertificate() {
    const connection = new web3.Connection(
      web3.clusterApiUrl("devnet"),
      "confirmed"
    );

    const from = web3.Keypair.generate();
    const airdropSignature = await connection.requestAirdrop(
      from.publicKey,
      web3.LAMPORTS_PER_SOL // 10000000 Lamports in 1 SOL
    );
    await connection.confirmTransaction(airdropSignature);

    // Generate a new random public key
    const to = web3.Keypair.generate();

    const transaction = new web3.Transaction().add(
      web3.SystemProgram.transfer({
        fromPubkey: from.publicKey,
        toPubkey: to.publicKey,
        lamports: web3.LAMPORTS_PER_SOL / 100,
      })
    );

    // Sign transaction, broadcast, and confirm
    const signature = await web3.sendAndConfirmTransaction(
      connection,
      transaction,
      [from]
    );
    console.log("SIGNATURE", signature);

    return signature;
  }
}

export default new SendCertificate();
