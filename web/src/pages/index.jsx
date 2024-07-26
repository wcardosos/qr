import { Header } from "@/components/header"
import { Button } from "@/components/ui/button"
import * as React from "react"

const IndexPage = () => {
  return (
    <div className="bg-zinc-900 text-zinc-50 min-h-screen">
      <Header />

      <main className="max-w-screen-xl mx-auto py-10 px-6">
        <div className="flex flex-col items-center text-center max-w-[40rem] mx-auto gap-6">
          <h1 className="font-bold text-5xl text-cyan-500">Generate QR Codes instantly</h1>
          <p className="text-zinc-400">Transform any text, link, or information into a QR Code quickly and easily. Ideal for your marketing campaigns, business cards, or sharing information effortlessly.</p>
          <Button className="mt-4 bg-cyan-600 text-xl">Generate QR Code now</Button>
        </div>
        <h1 className="text-3xl font-bold">qr</h1>
      </main>
    </div>
  )
}

export default IndexPage

export const Head = () => <title>qr - Generate the QR code that you needs</title>
