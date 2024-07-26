import React from 'react';
import { Button } from "@/components/ui/button"
import { Github,  } from "lucide-react"
import { Logo } from "./logo"

export function Header() {
  return (
    <header className="max-w-screen-xl mx-auto py-10 px-6 flex justify-between items-center">
      <Logo />

      <Button className="bg-cyan-600 text-zinc-50 flex gap-1">
        <Github className="w-4 h-4" />
        <span>Github</span>
      </Button>
    </header>
  )
}